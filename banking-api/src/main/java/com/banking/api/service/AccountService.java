package com.banking.api.service;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public String getAccountStatus() {
        return "ACTIVE";
    }

}
