package com.glassdoor.test.intern.interfaces.impl;

//Private
//Getters Stetter
//Synchronized
//Comment
// Remove This

import com.glassdoor.test.intern.pymtProcDTO.IncomingRequest;
import com.glassdoor.test.intern.interfaces.PaymentProcessor;

public class CardScheme implements PaymentProcessor {
    IncomingRequest incomingRequest;
    private boolean paymentStatus;

    public CardScheme(IncomingRequest i) throws Exception {
        incomingRequest = i;
        paymentStatus = false;
        processPayment();
    }
    @Override
    public void processPayment() throws Exception {
        // Route to Issuing Bank
        chargeFee();
        IssuingBank issuingBank = new IssuingBank(incomingRequest);
        if (issuingBank.getPaymentStatus()) {
            incomingRequest.setAmount(issuingBank.incomingRequest.getAmount());
            setPaymentStatus();
        }
    }

    @Override
    public void chargeFee() {
    // Charge a 20% fee
        incomingRequest.setAmount(incomingRequest.getAmount() + (0.20F * incomingRequest.getOriginalAmount()));
    }

    @Override
    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public void setPaymentStatus() {paymentStatus = true;}
}
