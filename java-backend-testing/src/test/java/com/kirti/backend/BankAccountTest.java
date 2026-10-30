package com.kirti.backend;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {

    @Test
    public void testInsufficientBalance() {
        BankAccount account1 = new BankAccount(3000);
        assertThrows(InsufficientBalanceException.class, () -> account1.withdraw(8000));
    }

    @Test
    public void testSuccessfulWithdrawal() {
        BankAccount account1 = new BankAccount(3000);
        assertDoesNotThrow(() -> account1.withdraw(1000));
    }

    @Test
    public void testInsufficientBalanceMessage() {
        BankAccount account1 = new BankAccount(3000);
        InsufficientBalanceException exception = assertThrows(InsufficientBalanceException.class,
                () -> account1.withdraw(8000));
        assertEquals("Insufficient balance", exception.getMessage());
    }

    @Test
    public void testExactBalanceWithdrawal() {
        BankAccount account1 = new BankAccount(3000);
        assertDoesNotThrow(() -> account1.withdraw(3000));
    }

    @Test
    public void testBalanceAfterWithdrawal() {
        BankAccount account1 = new BankAccount(5000);
        assertDoesNotThrow(() -> account1.withdraw(2000));
        assertEquals(3000, account1.getBalance());
    }

    @Test
    public void testMultipleWithdrawals() {
        BankAccount account1 = new BankAccount(10000);
        account1.withdraw(3000);
        assertEquals(7000, account1.getBalance());
        account1.withdraw(2500);
        assertEquals(4500, account1.getBalance());
    }

    @Test
    public void testBalanceUnchangedAfterFailedWithdrawal() {
        BankAccount account1 = new BankAccount(5000);
        assertThrows(InsufficientBalanceException.class, () -> account1.withdraw(8000));
        assertEquals(5000, account1.getBalance());
    }

    @Test
    public void testNegativeWithdrawal() {
        BankAccount account1 = new BankAccount(5000);
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(-1000));
        assertEquals(5000, account1.getBalance());
    }

    @Test
    public void testZeroWithdrawal() {
        BankAccount account1 = new BankAccount(5000);
        assertThrows(IllegalArgumentException.class, () -> account1.withdraw(0));
        assertEquals(5000, account1.getBalance());
    }

}
