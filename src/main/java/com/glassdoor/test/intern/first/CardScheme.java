package com.glassdoor.test.intern.first;

public class CardScheme implements PaymentProcessor{
    IncomingRequest incomingRequest;
    private boolean paymentStatus;

    public CardScheme(IncomingRequest i) throws Exception {
        this.incomingRequest = i;
        this.process_payment();
    }
    @Override
    public void process_payment() throws Exception {
        // Route to Issuing Bank
        this.chargeFee();
        IssuingBank issuingBank = new IssuingBank(this.incomingRequest);
        if (issuingBank.getPaymentStatus()) {
            this.incomingRequest.amount = issuingBank.incomingRequest.amount;
            this.paymentStatus = true;
        }
    }

    @Override
    public void chargeFee() {
    // Charge a 20% fee
        this.incomingRequest.amount += 0.20 * this.incomingRequest.original_amount;
    }

    public boolean getPaymentStatus() {
        return this.paymentStatus;
    }
}
