package com.banking.api.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(long accountId){
        super("Account " + accountId + " not found");
    }
}
