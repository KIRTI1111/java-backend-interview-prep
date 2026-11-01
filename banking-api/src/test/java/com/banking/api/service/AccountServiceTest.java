package com.banking.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AccountServiceTest {

    @Test
    void testGetAccountStatus() {
        AccountService service = new AccountService();
        String result = service.getAccountStatus();
        assertEquals("ACTIVE", result);
    }

}
