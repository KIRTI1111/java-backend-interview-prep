package com.banking.api.service;

import com.banking.api.exception.AccountNotFoundException;
import com.banking.api.repository.AccountRepository;

import org.springframework.stereotype.Service;

import com.banking.api.dto.AccountRequest;
import com.banking.api.dto.AccountResponse;
import com.banking.api.entity.Account;

import java.util.Map;
import java.math.BigDecimal;
import java.util.HashMap;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    private final Map<Long, AccountResponse> accounts = new HashMap<>();
    private long nextAccountId = 100L;

    public String getAccountStatus() {
        return "ACTIVE";
    }

    // public AccountResponse createAccount(AccountRequest request) {
    // AccountResponse account = new AccountResponse(nextAccountId,
    // request.getAccountHolder(), request.getBalance(),
    // "ACTIVE");
    // accounts.put(account.getAccountId(), account);
    // nextAccountId++;
    // return account;
    // }

    public AccountResponse createAccount(AccountRequest request) {
        Account account = new Account();
        account.setAccountHolder(request.getAccountHolder());
        account.setBalance(BigDecimal.valueOf(request.getBalance()));
        account.setStatus("ACTIVE");
        Account savedAccount = accountRepository.save(account);
        return new AccountResponse(savedAccount.getAccountId(), savedAccount.getAccountHolder(), savedAccount.getBalance().doubleValue(), savedAccount.getStatus());

    }

    // public AccountResponse getAccountDetails(long accountId) {
    //     AccountResponse account = accounts.get(accountId);
    //     if (account == null) {
    //         throw new AccountNotFoundException(accountId);
    //     }
    //     return account;
    // }

    public AccountResponse getAccountDetails(long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new AccountNotFoundException(accountId));
        return new AccountResponse(account.getAccountId(), account.getAccountHolder(), account.getBalance().doubleValue(), account.getStatus());
    }

    public AccountResponse deposit(long accountId, double amount) {
        AccountResponse account = accounts.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException(accountId);
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be greater than zero");
        }
        double newBalance = account.getBalance() + amount;

        AccountResponse updatedAccount = new AccountResponse(account.getAccountId(), account.getAccountHolder(),
                newBalance, account.getStatus());

        accounts.put(account.getAccountId(), updatedAccount);

        return updatedAccount;
    }

    public AccountResponse updateAccountHolder(long accountId, String newName) {
        AccountResponse account = accounts.get(accountId);
        if (account == null) {
            throw new AccountNotFoundException(accountId);
        }

        AccountResponse updatedAccount = new AccountResponse(account.getAccountId(), newName,
                account.getBalance(), account.getStatus());

        accounts.put(account.getAccountId(), updatedAccount);

        return updatedAccount;
    }

}
