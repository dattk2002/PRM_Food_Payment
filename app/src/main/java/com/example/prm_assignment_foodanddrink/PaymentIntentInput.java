package com.example.prm_assignment_foodanddrink;

public class PaymentIntentInput {
    int amount;
    String currency;

    public PaymentIntentInput(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
