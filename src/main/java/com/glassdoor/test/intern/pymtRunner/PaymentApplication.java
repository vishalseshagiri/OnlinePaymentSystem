package com.glassdoor.test.intern.pymtRunner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.glassdoor.test.intern.interfaces.impl.AcquiringBank;
import com.glassdoor.test.intern.pymtProcDTO.IncomingRequest;

public class PaymentApplication {
    private static final Logger logger = LogManager.getLogger(PaymentApplication.class);
    //  private static final Logger logger = LogManager.getLogger();
    public static void main(String[] args) throws Exception {

        try {
            IncomingRequest incomingRequest = new IncomingRequest(1, "ABC", "123 Some Street, City Name, ST", 1, 1, "1234567891011121", "Visa", "Trader Joe's", false, "password", "90008");
            logger.info("Transaction Initiated");
            AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
            logger.info("Transaction completed");
            logger.info(acquiringBank.incomingRequest.getAmount());
        } catch (Exception e) {
            logger.error("Exception encountered ", e);
            logger.error("Transaction aborted");
        }

    }
}