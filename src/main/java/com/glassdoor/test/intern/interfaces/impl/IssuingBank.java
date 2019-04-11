package com.glassdoor.test.intern.interfaces.impl;

import com.glassdoor.test.intern.pymtProcDTO.IncomingRequest;
import com.glassdoor.test.intern.pymtProcDTO.UserObject;
import com.glassdoor.test.intern.interfaces.PaymentProcessor;

public class IssuingBank implements PaymentProcessor {

    IncomingRequest incomingRequest;
    private boolean paymentStatus;

    public IssuingBank(IncomingRequest i) throws Exception {
        incomingRequest = i;
        processPayment();
        paymentStatus = false;
    }

    @Override
    public void processPayment() throws Exception {
        chargeFee();
        UserDatabase userDatabase = new UserDatabase();
        // Check if user exists ?
        if (userDatabase.users.containsKey(incomingRequest.getUserId())) {
            UserObject user = userDatabase.users.get(incomingRequest.getUserId());
            // If isCardPresentTransaction
            if (incomingRequest.isCardPresentTransaction()) {
                if (!incomingRequest.getPin().equals(user.getCardPin())) {
                    System.out.println(incomingRequest.getPin() + " " + user.getCardPin());
                    throw new Exception("Illegal Transaction request, Pin is incorrect !");
                }
            }
            // Does the billing address and incomingRequest address correct
            if (user.getAddress().equals(incomingRequest.getBillingAddress())) {
                // Is there enough credit ?
                if (user.getAccountBalance() > incomingRequest.getAmount()) {
                    // Was the card stolen ?
                    if (!user.isCardStolen()) {
                        // Location of transaction ?
                        // Google maps integration if possible
                        paymentStatus = true;
                    } else {
                        throw new Exception("Illegal Transaction request, Card is Stolen !");
                    }
                } else {
                    throw new Exception("Illegal Transaction request, Insufficient Funds !");
                }
            } else {
                throw new Exception("Illegal Transaction request, Billing Address does not match !");
            }
        } else {
            throw new Exception("Illegal Transaction request, User is not a customer of Issuing Bank !");
        }
    }

    @Override
    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public void chargeFee() {
        // Charge a 5% fee
        incomingRequest.setAmount(incomingRequest.getAmount() + (0.05F * incomingRequest.getOriginalAmount()));
    }
}
