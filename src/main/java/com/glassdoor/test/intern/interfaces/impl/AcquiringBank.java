package com.glassdoor.test.intern.interfaces.impl;

//Gracefully Handle Exception Failure
//Getters Setter
//SYNCHRONIZED METHOD

//Comment

import com.glassdoor.test.intern.pymtProcDTO.IncomingRequest;
import com.glassdoor.test.intern.interfaces.PaymentProcessor;

/**
 * Explanaion
 */
public class AcquiringBank implements PaymentProcessor {

    public IncomingRequest incomingRequest;
    public boolean paymentStatus;

    public AcquiringBank(IncomingRequest i) throws Exception {
       this.incomingRequest = i;
       this.processPayment();
       paymentStatus = false;
    }


    @Override
    public void processPayment() throws Exception {
        // Checks if merchant exists
        MerchantDatabase merchantDatabase = new MerchantDatabase();
        if (merchantDatabase.merchants.contains(incomingRequest.getMerchant())) {
            chargeFee();
            CardScheme cardScheme = new CardScheme(incomingRequest);
            if (cardScheme.getPaymentStatus()) {
                incomingRequest.setAmount(cardScheme.incomingRequest.getAmount());
                paymentStatus = true;
                submitPayment();
            }
        } else {

            throw new Exception("Illegal Argument Exception, Merchant does not exist !");
        }
    }

    private void submitPayment() {
        System.out.println(String.format("Payment of %f processed", incomingRequest.getAmount()));
    }

    @Override
    public void chargeFee() {
        // Charge a 10% fee
        incomingRequest.setAmount(incomingRequest.getAmount() + (0.10F * incomingRequest.getOriginalAmount()));
    }

    public boolean getPaymentStatus() {
       return paymentStatus;
    }

}
