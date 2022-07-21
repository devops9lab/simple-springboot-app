package com.pcloud.simplespringbootapp.api;

import com.pcloud.simplespringbootapp.db.Account;
import com.pcloud.simplespringbootapp.db.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bucket4j")
public class Bucket4JRestController {

    private final AccountRepository accountRepository;

    public Bucket4JRestController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public Page<Account> getAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }
}
