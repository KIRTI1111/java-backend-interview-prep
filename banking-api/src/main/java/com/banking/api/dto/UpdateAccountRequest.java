package com.banking.api.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * UpdateAccountRequest
 */
public class UpdateAccountRequest {
    
    @NotBlank(message = "Account holder name is required")
    private String accountHolder;

    public String getAccountHolder() {
        return accountHolder;
    }
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
}
