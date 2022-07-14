package com.pcloud.simplespringbootapp.api;

import com.pcloud.simplespringbootapp.db.Account;
import com.pcloud.simplespringbootapp.db.AccountRepository;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {
    private final AccountRepository accountRepository;

    public AccountRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RateLimiter(name = "basic")
    @GetMapping
    public Page<Account> getAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }
}
