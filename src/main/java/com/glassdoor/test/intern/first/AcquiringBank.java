package com.glassdoor.test.intern.first;

public class AcquiringBank implements PaymentProcessor{

    IncomingRequest incomingRequest;
    private boolean paymentStatus = false;

    public AcquiringBank(IncomingRequest i) throws Exception {
       this.incomingRequest = i;
       this.process_payment();
    }

    @Override
    public void process_payment() throws Exception {
        // Checks if merchant exists
        MerchantDatabase merchantDatabase = new MerchantDatabase();
        if (merchantDatabase.merchants.contains(this.incomingRequest.merchant)) {
            this.chargeFee();
            CardScheme cardScheme = new CardScheme(this.incomingRequest);
            if (cardScheme.getPaymentStatus()) {
                this.incomingRequest.amount = cardScheme.incomingRequest.amount;
                this.paymentStatus = true;
                this.submitPayment();
            }
        }
    }

    private void submitPayment() {
        System.out.println(String.format("Payment of %f processed", this.incomingRequest.amount));
    }

    @Override
    public void chargeFee() {
        // Charge a 10% fee
        this.incomingRequest.amount += 0.10 * this.incomingRequest.original_amount;
    }

    public boolean getPaymentStatus() {
       return this.paymentStatus;
    }

}
