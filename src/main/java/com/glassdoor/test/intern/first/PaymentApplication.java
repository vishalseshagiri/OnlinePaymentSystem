package com.glassdoor.test.intern.first;

public class PaymentApplication {
  public static void main(String[] args) throws Exception {
    IncomingRequest incomingRequest = new IncomingRequest();
    incomingRequest.userId = 1;
    incomingRequest.userName = "ABC";
    incomingRequest.billingAddress = "123 Some Street, City Name, ST";
    incomingRequest.amount = 1;
    incomingRequest.original_amount = 1;
    incomingRequest.cardNumber = "1234567891011121";
    incomingRequest.cardScheme = "Visa";
    incomingRequest.merchant = "Trader Joe's";
    incomingRequest.isCardPresentTransaction = true;
    incomingRequest.setPin("password");
    incomingRequest.transactionLocation = "90008";
    System.out.println(incomingRequest.toString());
    AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
  }
}