package com.glassdoor.test.intern.pymtProcDTO;


//Private
//Getters Setters
//Comment
public class UserObject {
    private int userId;
    private String userName;
    private String cardNumber;
    private String address;
    private float accountBalance;
    private String cardPin;
    private boolean cardStolen;

    public UserObject(String[] userList) {
        setUserId(Integer.parseInt(userList[0]));
        setUserName(userList[1]);
        setCardNumber(userList[2]);
        setAddress(userList[3]);
        setAccountBalance(Float.parseFloat(userList[4]));
        setCardPin(userList[5]);
        setCardStolen(Boolean.parseBoolean(userList[6]));
    }

    @Override
    public String toString() {
        return String.format("userId:%d\nuserName:%s\ncardNumber:%s\naddress:%s\naccountBalance:%f\ncardStole:%s", getUserId(), getUserName(), getCardNumber(), getAddress(), getAccountBalance(), Boolean.toString(isCardStolen()));
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

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getCardPin() {
        return cardPin;
    }

    public void setCardPin(String cardPin) {
        this.cardPin = cardPin;
    }

    public boolean isCardStolen() {
        return cardStolen;
    }

    public void setCardStolen(boolean cardStolen) {
        this.cardStolen = cardStolen;
    }
}