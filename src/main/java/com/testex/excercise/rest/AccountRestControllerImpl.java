package com.testex.excercise.rest;

import com.testex.excercise.service.AccountService;
import org.springframework.web.bind.annotation.*;


@RestController
public class AccountRestControllerImpl  {

    private final AccountService accountService;

    public AccountRestControllerImpl(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/")
    public Long getAmount(@RequestParam Integer id){
        return accountService.getAmount(id);
    }

    @PostMapping("/")
    public void addAmount(@RequestParam Integer id, @RequestParam Long amount){
        accountService.addAmount(id, amount);
    }

}
