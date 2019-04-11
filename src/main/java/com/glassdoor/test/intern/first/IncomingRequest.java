package com.glassdoor.test.intern.first;

public class IncomingRequest {

  private int userId;
  private String userName;
  private String billingAddress;
  private float originalAmount;
  private float amount;
  private String cardNumber;
  private String cardScheme;
  private boolean isCardPresentTransaction = false;
  private String cardPin;
  private String merchant;
  private String transactionLocation;

  public IncomingRequest() {

  }

  public IncomingRequest(int userId, String userName, String billingAddress,float original_amount, float amount, String cardNumber, String cardScheme, String merchant, String transactionLocation) {
    setUserId(userId);
    setUserName(userName);
    setBillingAddress(billingAddress);
    setAmount(amount);
    setOriginal_amount(original_amount);
    setCardNumber(cardNumber);
    setCardScheme(cardScheme);
    setMerchant(merchant);
    setTransactionLocation(transactionLocation);
  }

  // Overriden constructor for isCardPresentTransaction
  public IncomingRequest(int userId, String userName, String billingAddress, float amount, float original_amount, String cardNumber, String cardScheme, String merchant, boolean isCardPresentTransaction, String cardPin, String transactionLocation) throws Exception {
    setUserId(userId);
    setUserName(userName);
    setBillingAddress(billingAddress);
    setAmount(amount);
    setOriginal_amount(original_amount);
    setCardNumber(cardNumber);
    setCardScheme(cardScheme);
    setCardPresentTransaction(isCardPresentTransaction);
    setMerchant(merchant);
    setTransactionLocation(transactionLocation);
    if (isCardPresentTransaction()) {
      setPin(cardPin);
    }
  }


  // Retrun Type Boolean
  // Add Error Messages to Other Class

  public void setPin(String pinSequence) throws Exception {
    if (isCardPresentTransaction()) {
      setCardPin(pinSequence);
    } else {
      throw new Exception("Illegal Transaction request, this is a CardNotPresent Transaction");
    }
  }

  public String getPin() throws Exception {
    // Method for business users
    if (isCardPresentTransaction()) {
      return getCardPin();
    } else {
      throw new Exception("Illegal Transaction request, this is a CardNotPresent Transaction");
    }
  }

  public String toString() {
    return String.format("userId : %d\nuserName : %s\nbillingAddress : %s\namount : %f\ncardNumber : %s\ncardScheme : %s\n", getUserId(), getBillingAddress(), getAmount(), getCardNumber(), getCardScheme());
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getBillingAddress() {
    return billingAddress;
  }

  public void setBillingAddress(String billingAddress) {
    this.billingAddress = billingAddress;
  }

  public float getOriginal_amount() {
    return originalAmount;
  }

  public void setOriginal_amount(float originalAmount) {
    this.originalAmount = originalAmount;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public String getCardScheme() {
    return cardScheme;
  }

  public void setCardScheme(String cardScheme) {
    this.cardScheme = cardScheme;
  }

  public boolean isCardPresentTransaction() {
    return isCardPresentTransaction;
  }

  public void setCardPresentTransaction(boolean cardPresentTransaction) {
    isCardPresentTransaction = cardPresentTransaction;
  }

  public String getCardPin() {
    return cardPin;
  }

  public void setCardPin(String cardPin) {
    this.cardPin = cardPin;
  }

  public String getMerchant() {
    return merchant;
  }

  public void setMerchant(String merchant) {
    this.merchant = merchant;
  }

  public String getTransactionLocation() {
    return transactionLocation;
  }

  public void setTransactionLocation(String transactionLocation) {
    this.transactionLocation = transactionLocation;
  }
}