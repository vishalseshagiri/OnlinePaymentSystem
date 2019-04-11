package com.glassdoor.test.intern.interfaces;

/*
 * PaymentProcessor
 */
public interface PaymentProcessor {

    void processPayment() throws Exception;
    void chargeFee();
    boolean getPaymentStatus();
    void setPaymentStatus();

}