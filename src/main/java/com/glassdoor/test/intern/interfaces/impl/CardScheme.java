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
        this.incomingRequest = i;
        this.processPayment();
    }
    @Override
    public void processPayment() throws Exception {
        // Route to Issuing Bank
        this.chargeFee();
        IssuingBank issuingBank = new IssuingBank(this.incomingRequest);
        if (issuingBank.getPaymentStatus()) {
            this.incomingRequest.setAmount(issuingBank.incomingRequest.getAmount());
            this.paymentStatus = true;
        }
    }

    @Override
    public void chargeFee() {
    // Charge a 20% fee
        this.incomingRequest.setAmount(incomingRequest.getAmount() + (0.20F * incomingRequest.getOriginalAmount()));
    }

    public boolean getPaymentStatus() {
        return this.paymentStatus;
    }
}
