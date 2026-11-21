package com.banking.api.dto;

import jakarta.validation.constraints.Positive;

/**
 * DepositRequest
 */
public class DepositRequest {
    @Positive(message = "Deposit amount must be greater than zero")

    private double amount;

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
