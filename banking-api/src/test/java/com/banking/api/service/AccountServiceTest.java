package com.banking.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.banking.api.dto.AccountResponse;
import com.banking.api.entity.Account;
import com.banking.api.repository.AccountRepository;

import java.util.Optional;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AccountServiceTest {

    @Test
    void testGetAccountStatus() {
        // AccountService service = new AccountService();
        AccountRepository mockRepository = mock(AccountRepository.class);
        AccountService service = new AccountService(mockRepository);
        String result = service.getAccountStatus();
        assertEquals("ACTIVE", result);
    }

    @Test
    void shouldReturnCorrectAccountDetails() {
        // AccountService service = new AccountService();
        AccountRepository mockRepository = mock(AccountRepository.class);
        AccountService service = new AccountService(mockRepository);
        Account account = new Account();
        account.setAccountId(1L);
        account.setAccountHolder("Anita");
        account.setBalance(BigDecimal.valueOf(15000));
        account.setStatus("ACTIVE");

        when(mockRepository.findById(1L))
                .thenReturn(Optional.of(account));
        AccountResponse response = service.getAccountDetails(1L);
        assertEquals(1L, response.getAccountId());
        assertEquals("Anita", response.getAccountHolder());
        assertEquals(15000.0, response.getBalance());
        assertEquals("ACTIVE", response.getStatus());
    }

}
