package com.banking.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.api.dto.AccountRequest;
import com.banking.api.dto.AccountResponse;
import com.banking.api.service.AccountService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/status")
    public String status() {
        return service.getAccountStatus();
    }

    @GetMapping("/101")
    public AccountResponse details() {
        return service.getAccountDetails();
    }

    @PostMapping
    public String createAccount(@Valid @RequestBody AccountRequest accountRequest) {
        return "Account received for " + accountRequest.getAccountHolder();
    }
}
