package com.pcloud.simplespringbootapp.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Override
    Page<Account> findAll(Pageable pageable);
}
