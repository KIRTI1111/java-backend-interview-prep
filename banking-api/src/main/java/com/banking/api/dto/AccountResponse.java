package com.banking.api.dto;

public class AccountResponse {

    private long accountId;
    private String accountHolder;
    private double balance;
    private String status;

    public AccountResponse(long accountId, String accountHolder, double balance, String status) {
        this.accountId = accountId;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.status = status;
    }

    public long getAccountId() {
        return accountId;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public String getStatus() {
        return status;
    }

}
