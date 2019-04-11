package com.glassdoor.test.intern.pymtProcDTO;

public final class ErrorHandler {
    public static final String CARDNOTPRESENT = "Illegal Transaction request, this is a CardNotPresent Transaction";

    public static final String MERCHANTDOESNOTEXIT = "Illegal Argument Exception, Merchant does not exist !";

    public static final String INCORRECTPIN = "Illegal Transaction request, Pin is incorrect !";

    public static final String  STOLENCARD = "Illegal Transaction request, Card is Stolen !";

    public static final String INSUFFICIENTFUNDS = "Illegal Transaction request, Insufficient Funds !";

    public static final String ADDRESSMISMATCH = "Illegal Transaction request, Billing Address does not match !";

    public static final String CUSTOMERDOESNOTEXIST = "Illegal Transaction request, User is not a customer of Issuing Bank !";
}