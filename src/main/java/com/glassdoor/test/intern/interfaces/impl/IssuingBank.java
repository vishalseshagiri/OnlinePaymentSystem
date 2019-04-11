package com.glassdoor.test.intern.interfaces.impl;

import com.glassdoor.test.intern.pymtProcDTO.ErrorHandler;
import com.glassdoor.test.intern.pymtProcDTO.IncomingRequest;
import com.glassdoor.test.intern.pymtProcDTO.UserObject;
import com.glassdoor.test.intern.interfaces.PaymentProcessor;

public class IssuingBank implements PaymentProcessor {

    IncomingRequest incomingRequest;
    private boolean paymentStatus;

    public IssuingBank(IncomingRequest i) throws Exception {
        paymentStatus = false;
        incomingRequest = i;
        processPayment();
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
                    throw new Exception(ErrorHandler.INCORRECTPIN);
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
                        setPaymentStatus();
                    } else {
                        throw new Exception(ErrorHandler.STOLENCARD);
                    }
                } else {
                    throw new Exception(ErrorHandler.INSUFFICIENTFUNDS);
                }
            } else {
                throw new Exception(ErrorHandler.ADDRESSMISMATCH);
            }
        } else {
            throw new Exception(ErrorHandler.CUSTOMERDOESNOTEXIST);
        }
    }

    @Override
    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public void setPaymentStatus() {paymentStatus = true;}

    @Override
    public void chargeFee() {
        // Charge a 5% fee
        incomingRequest.setAmount(incomingRequest.getAmount() + (0.05F * incomingRequest.getOriginalAmount()));
    }
}
