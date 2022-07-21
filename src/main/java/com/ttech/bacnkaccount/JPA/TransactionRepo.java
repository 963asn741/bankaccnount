package com.ttech.bacnkaccount.JPA;

import org.springframework.data.repository.CrudRepository;
import com.ttech.bacnkaccount.Entitiy.Transaction;

public interface TransactionRepo extends CrudRepository<Transaction, Integer>{
    
}
