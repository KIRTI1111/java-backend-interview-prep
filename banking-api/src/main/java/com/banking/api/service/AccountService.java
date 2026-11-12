package com.banking.api.service;

import com.banking.api.exception.AccountNotFoundException;

import org.springframework.stereotype.Service;

import com.banking.api.dto.AccountResponse;

@Service
public class AccountService {

    public String getAccountStatus() {
        return "ACTIVE";
    }

    public AccountResponse getAccountDetails(long accountId) {
        if(accountId != 101L){
            throw new AccountNotFoundException(accountId);
        }
        return new AccountResponse(101L, "Rahul", 25000.0, "ACTIVE");
    }

}
