package com.ttech.bacnkaccount.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttech.bacnkaccount.JPA.TransactionRepo;
import com.ttech.bacnkaccount.Entitiy.Transaction;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepo transactionsTable;

    public List<Transaction> showAllTransactions(){
        List<Transaction> transactions = new ArrayList<>();
        for(Transaction t : transactionsTable.findAll())
        {
            System.out.println(t.getId());
        }

        System.out.println(transactionsTable.count());

        transactionsTable.findAll().forEach(transactions::add);
        return transactions;
    }

    public List<Transaction> getTransactionsOfAccount(int accountId){
        return transactionsTable.findByAccountId(accountId);
    }

    public Transaction getTransaction(int id){
        return transactionsTable.findById(id).get();
    }

    public void addTransaction(Transaction newTransaction){
        transactionsTable.save(newTransaction);
    }
}