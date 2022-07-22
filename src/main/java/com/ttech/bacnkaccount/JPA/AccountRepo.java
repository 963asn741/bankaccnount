package com.ttech.bacnkaccount.JPA;

import org.springframework.data.repository.CrudRepository;
import com.ttech.bacnkaccount.Entitiy.Account;

public interface AccountRepo extends CrudRepository<Account, Integer>{
}
