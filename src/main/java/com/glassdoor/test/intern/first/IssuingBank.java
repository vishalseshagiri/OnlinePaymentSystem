package com.glassdoor.test.intern.first;

public class IssuingBank implements PaymentProcessor{

    IncomingRequest incomingRequest;
    private boolean paymentStatus = false;

    public IssuingBank(IncomingRequest i) throws Exception {
        this.incomingRequest = i;
        this.process_payment();
    }

    @Override
    public void process_payment() throws Exception {
        this.chargeFee();
        UserDatabase userDatabase = new UserDatabase();
        // Check if user exists ?
        if (userDatabase.users.containsKey(this.incomingRequest.userId)) {
            UserObject user = userDatabase.users.get(this.incomingRequest.userId);
            // If isCardPresentTransaction
            if (this.incomingRequest.isCardPresentTransaction) {
                if (!this.incomingRequest.getPin().equals(user.cardPin)) {
                    throw new Exception("Illegal Transaction request, Pin is incorrect !");
                }
            }
            // Does the billing address and incomingRequest address correct
            if (user.address.equals(this.incomingRequest.billingAddress)) {
                // Is there enough credit ?
                if (user.accountBalance > this.incomingRequest.amount) {
                    // Was the card stolen ?
                    if (!user.cardStolen) {
                        // Location of transaction ?
                        // Google maps integration if possible
                        this.paymentStatus = true;
                    } else {
                        throw new Exception("Illegal Transaction request, Card is Stolen !");
                    }
                } else {
                    throw new Exception("Illegal Transaction request, Insufficient Funds !");
                }
            } else {
                throw new Exception("Illegal Transaction request, Billing Address does not match !");
            }
        } else {
            throw new Exception("Illegal Transaction request, User is not a customer of Issuing Bank !");
        }
    }

    public boolean getPaymentStatus() {
        return this.paymentStatus;
    }

    @Override
    public void chargeFee() {
        // Charge a 5% fee
        this.incomingRequest.amount += 0.05 * this.incomingRequest.original_amount;
    }
}
