package com.glassdoor.test.intern.first;

import java.util.ArrayList;
import java.util.List;

public class UserObject {
    int userId;
    String userName;
    String cardNumber;
    String address;
    float accountBalance;
    String cardPin;
    boolean cardStolen;

    public UserObject(String[] userList) {
        this.userId = Integer.parseInt(userList[0]);
        this.userName = userList[1];
        this.cardNumber = userList[2];
        this.address = userList[3];
        this.accountBalance = Float.parseFloat(userList[4]);
        this.cardPin = userList[5];
        this.cardStolen = Boolean.parseBoolean(userList[6]);
    }

    @Override
    public String toString() {
        return String.format("userId:%d\nuserName:%s\ncardNumber:%s\naddress:%s\naccountBalance:%f\ncardStole:%s",this.userId, this.userName, this.cardNumber, this.address, this.accountBalance, Boolean.toString(this.cardStolen));
    }
}