package com.pcloud.simplespringbootapp.api;

import com.pcloud.simplespringbootapp.db.Account;
import com.pcloud.simplespringbootapp.db.AccountRepository;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import javax.annotation.PostConstruct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountRestController {

    private final RateLimiterRegistry rateLimiterRegistry;
    private final AccountRepository accountRepository;

    public AccountRestController(AccountRepository accountRepository, RateLimiterRegistry rateLimiterRegistry) {
        this.accountRepository = accountRepository;
        this.rateLimiterRegistry = rateLimiterRegistry;
    }

    @PostConstruct
    public void postConstruct() {
        io.github.resilience4j.ratelimiter.RateLimiter.EventPublisher eventPublisher = rateLimiterRegistry
            .rateLimiter("basic")
            .getEventPublisher();

        eventPublisher.onSuccess(System.out::println);
        eventPublisher.onFailure(System.out::println);
    }


    @RateLimiter(name = "basic")
    @GetMapping
    public Page<Account> getAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }
}
