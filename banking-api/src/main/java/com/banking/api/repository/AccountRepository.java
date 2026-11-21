package com.banking.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banking.api.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

    
}
