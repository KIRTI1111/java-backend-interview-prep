package com.banking.api.dto;

public class AccountRequest {

    private String accountHolder;
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
