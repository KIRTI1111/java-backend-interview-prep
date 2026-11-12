package com.banking.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.banking.api.dto.AccountResponse;

public class AccountServiceTest {

    @Test
    void testGetAccountStatus() {
        AccountService service = new AccountService();
        String result = service.getAccountStatus();
        assertEquals("ACTIVE", result);
    }

    @Test 
    void shouldReturnCorrectAccountDetails() {
        AccountService service = new AccountService();
        AccountResponse response = service.getAccountDetails(101L);
        assertEquals(101L, response.getAccountId());
        assertEquals("Rahul", response.getAccountHolder());
        assertEquals(25000.0, response.getBalance());
        assertEquals("ACTIVE", response.getStatus());
    }

}
