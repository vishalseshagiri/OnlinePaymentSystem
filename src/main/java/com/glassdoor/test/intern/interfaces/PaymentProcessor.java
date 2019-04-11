package com.glassdoor.test.intern.interfaces;


//Comment
public interface PaymentProcessor {

    void processPayment() throws Exception;
    void chargeFee();
    boolean getPaymentStatus();

}