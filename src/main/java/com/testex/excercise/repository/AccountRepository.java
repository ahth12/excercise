package com.testex.excercise.repository;

import com.testex.excercise.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
