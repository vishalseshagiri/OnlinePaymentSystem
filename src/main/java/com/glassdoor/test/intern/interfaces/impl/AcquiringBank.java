package com.glassdoor.test.intern.interfaces.impl;

//Gracefully Handle Exception Failure
//SYNCHRONIZED METHOD

//Comment

import com.glassdoor.test.intern.pymtProcDTO.ErrorHandler;
import com.glassdoor.test.intern.pymtProcDTO.IncomingRequest;
import com.glassdoor.test.intern.interfaces.PaymentProcessor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * Explanaion
 */
public class AcquiringBank implements PaymentProcessor {

    public IncomingRequest incomingRequest;
    private boolean paymentStatus;
    private static final Logger logger = LogManager.getLogger(AcquiringBank.class);

    public AcquiringBank(IncomingRequest i) throws Exception {
       paymentStatus = false;
       incomingRequest = i;
       processPayment();
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
                setPaymentStatus();
                submitPayment();
            }
        } else {

//            throw new Exception("Illegal Argument Exception, Merchant does not exist !");
            throw new Exception(ErrorHandler.MERCHANTDOESNOTEXIT);
        }
    }

    private void submitPayment() {
        logger.info(String.format("Payment of %f processed", incomingRequest.getAmount()));
    }

    @Override
    public void chargeFee() {
        // Charge a 10% fee
        incomingRequest.setAmount(incomingRequest.getAmount() + (0.10F * incomingRequest.getOriginalAmount()));
    }

    @Override
    public boolean getPaymentStatus() {
       return paymentStatus;
    }

    @Override
    public void setPaymentStatus() {paymentStatus = true;}

}
