package com.banking.api.service;

import org.springframework.stereotype.Service;

import com.banking.api.dto.AccountResponse;

@Service
public class AccountService {

    public String getAccountStatus() {
        return "ACTIVE";
    }

    public AccountResponse getAccountDetails() {
        return new AccountResponse(101L, "Rahul", 25000.0, "ACTIVE");
    }

}
