package com.testex.excercise.service;

import com.testex.excercise.model.Account;
import com.testex.excercise.repository.AccountRepository;
import io.micrometer.core.annotation.Timed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Timed
    @Override
    public Long getAmount(Integer id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            return accountOptional.get().getAmount();
        }
        else return 0L;
    }

    @Timed
    @Override
    public void addAmount(Integer id, Long value) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        accountOptional.ifPresentOrElse(account -> {
            account.setAmount(account.getAmount() + value);
            accountRepository.saveAndFlush(account);
        }, ()-> { accountRepository.save(new Account(value));
        });
    }

}
