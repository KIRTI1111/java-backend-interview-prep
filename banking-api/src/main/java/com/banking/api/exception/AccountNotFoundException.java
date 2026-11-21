package com.banking.api.exception;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(long accountId) {
        super("Bank account with ID " + accountId + " was not found");
    }
}
