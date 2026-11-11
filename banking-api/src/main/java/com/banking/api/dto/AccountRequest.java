package com.banking.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public class AccountRequest {

    @NotBlank(message = "Account holder name is required")
    private String accountHolder;

    @Positive(message = "Initial balance must be positive")
    private double balance;

    public AccountRequest() {

    }

    public String getAccountHolder() {
        return this.accountHolder;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
