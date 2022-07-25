package com.ttech.bacnkaccount.JPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ttech.bacnkaccount.Entitiy.Account;

public interface AccountRepo extends CrudRepository<Account, Integer>{
    public List<Account> findByCustomerId(int customerId);
}