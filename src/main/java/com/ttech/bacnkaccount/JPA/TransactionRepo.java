package com.ttech.bacnkaccount.JPA;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ttech.bacnkaccount.Entitiy.Transaction;


public interface TransactionRepo extends CrudRepository<Transaction, Integer>{
    public List<Transaction> findByAccountId(int customerId);
    
}
