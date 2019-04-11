package com.glassdoor.test.intern.first;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CardPresentTests {

    @Test
    public void cardPresent() throws Exception {
        // Arrange
        IncomingRequest incomingRequest = new IncomingRequest(3, "Vishal", "721W, 30th Street", 1, 1, "1234567891011121", "Visa", "Trader Joe's", true, "password", "90008");
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

    @Test(expectedExceptions = Exception.class)
    public void cardPresentBut
}
