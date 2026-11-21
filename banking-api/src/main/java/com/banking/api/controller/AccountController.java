package com.banking.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.api.dto.AccountRequest;
import com.banking.api.dto.AccountResponse;
import com.banking.api.dto.DepositRequest;
import com.banking.api.dto.UpdateAccountRequest;
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

    @GetMapping("/{accountId}")
    public AccountResponse details(@PathVariable long accountId) {
        return service.getAccountDetails(accountId);
    }

    // @PostMapping
    // public String createAccount(@Valid @RequestBody AccountRequest
    // accountRequest) {
    // return "Account received for " + accountRequest.getAccountHolder();
    // }

    @PostMapping
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest accountRequest) {
        AccountResponse account = service.createAccount(accountRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(account);
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<AccountResponse> updateAmount(@PathVariable long accountId,
            @Valid @RequestBody DepositRequest request) {
        AccountResponse updatedAccount = service.deposit(accountId, request.getAmount());
        return ResponseEntity
                .ok(updatedAccount);

    }

    @PatchMapping("/{accountId}/updateName")
    public ResponseEntity<AccountResponse> updateAccountHolderName(@PathVariable long accountId,
            @Valid @RequestBody UpdateAccountRequest request) {
        AccountResponse updatedAccount = service.updateAccountHolder(accountId, request.getAccountHolder());
        return ResponseEntity
                .ok(updatedAccount);
    }
}
