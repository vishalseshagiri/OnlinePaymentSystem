package com.glassdoor.test.intern;

import com.glassdoor.test.intern.interfaces.impl.AcquiringBank;
import com.glassdoor.test.intern.pymtProcDTO.ErrorHandler;
import com.glassdoor.test.intern.pymtProcDTO.IncomingRequest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentApplicationTests {

    @Test
    public void cardPresent() throws Exception {
        // Arrange
        IncomingRequest incomingRequest = new IncomingRequest(1, "ABC", "123 Some Street, City Name, ST", 1, 1, "1234567891011121", "Visa", "Trader Joe's", true, "password", "90008");
        AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
        final boolean actual = acquiringBank.getPaymentStatus();

        // Act
        final boolean expected = true;

        // Assert
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void cardNotPresent() throws Exception {
        // Arrange
        IncomingRequest incomingRequest = new IncomingRequest(3, "Vishal", "721W, 30th Street", 1, 1, "1234567891011121", "Visa", "Trader Joe's", "90008");
        AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
        final boolean actual = acquiringBank.getPaymentStatus();

        // Act
        final boolean expected = true;

        // Assert
        Assert.assertEquals(actual, expected);
    }

    @Test(expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = ErrorHandler.CARDNOTPRESENT)
    public void shouldThrowCardNotPresentException() throws Exception {
        // Arrange
        IncomingRequest incomingRequest = new IncomingRequest(1, "ABC", "123 Some Street, City Name, ST", 1, 1, "1234567891011121", "Visa", "Trader Joe's", false, "password", "90008");
        AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
    }

    @Test(expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = ErrorHandler.MERCHANTDOESNOTEXIT)
    public void shouldThrowMerchantDoesNotExistException() throws Exception {
        // Arrange
        IncomingRequest incomingRequest = new IncomingRequest(1, "ABC", "123 Some Street, City Name, ST", 1, 1, "1234567891011121", "Visa", "Costco", true, "password", "90008");
        AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
    }

    @Test(expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = ErrorHandler.INCORRECTPIN)
    public void shouldThrowIncorrectPinException() throws Exception {
        // Arrange
        IncomingRequest incomingRequest = new IncomingRequest(1, "ABC", "123 Some Street, City Name, ST", 1, 1, "1234567891011121", "Visa", "Trader Joe's", true, "passwords", "90008");
        AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
    }

    @Test(expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = ErrorHandler.STOLENCARD)
    public void shouldThrowStolenCardException() throws Exception {
        // Arrange
        // UserId 2 's card is stolen
        IncomingRequest incomingRequest = new IncomingRequest(2, "XYZ", "456 Other Street, Cool City, SS", 1, 1, "1234567891011122", "Visa", "Target", true, "password", "90008");
        AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
    }

    @Test(expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = ErrorHandler.INSUFFICIENTFUNDS)
    public void shouldThrowInsufficientFundsException() throws Exception {
        // Arrange
        IncomingRequest incomingRequest = new IncomingRequest(1, "ABC", "123 Some Street, City Name, ST", 100000, 100000, "1234567891011121", "Visa", "Trader Joe's", true, "password", "90008");
        AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
    }

    @Test(expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = ErrorHandler.ADDRESSMISMATCH)
    public void shouldThrowAddressMismatchException() throws Exception {
        // Arrange
        IncomingRequest incomingRequest = new IncomingRequest(1, "ABC", "12 Some Street, City Name, ST", 1, 1, "1234567891011121", "Visa", "Trader Joe's", true, "password", "90008");
        AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
    }

    @Test(expectedExceptions = { Exception.class }, expectedExceptionsMessageRegExp = ErrorHandler.CUSTOMERDOESNOTEXIST)
    public void shouldThrowCustomerDoesNotExistException() throws Exception {
        // Arrange
        IncomingRequest incomingRequest = new IncomingRequest(100, "ABC", "123 Some Street, City Name, ST", 1, 1, "1234567891011121", "Visa", "Trader Joe's", true, "password", "90008");
        AcquiringBank acquiringBank = new AcquiringBank(incomingRequest);
    }

}
