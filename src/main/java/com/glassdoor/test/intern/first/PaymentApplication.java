package com.glassdoor.test.intern.first;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.glassdoor.test.intern.interfaces.impl.AcquiringBank;
import com.glassdoor.test.intern.pymtProcDTO.IncomingRequest;

public class PaymentApplication {
  private static final Logger logger = LogManager.getLogger(PaymentApplication.class);
  public static void main(String[] args) throws Exception {

    IncomingRequest incomingRequest = new IncomingRequest();
    incomingRequest.setUserId(1);
    incomingRequest.setUserName("ABC");
    incomingRequest.setBillingAddress("123 Some Street, City Name, ST");
    incomingRequest.setAmount(1);
    incomingRequest.setOriginalAmount(1);
    incomingRequest.setCardNumber("1234567891011121");
    incomingRequest.setCardScheme("Visa");
    incomingRequest.setMerchant("Trader Joe's");
    incomingRequest.setCardPresentTransaction(false);
    try {
      incomingRequest.setPin("passwords");
    } catch (Exception e) {
      logger.info("Transaction aborted");
      logger.warn("Exception encountered ", e);
    }
    incomingRequest.setTransactionLocation("90008");
    System.out.println(incomingRequest.toString());
    try {
      AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
    } catch (Exception e) {
      logger.error("Exception encountered ", e);
      logger.warn("Transaction aborted");
    }
  }
}