package com.ttech.bacnkaccount.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttech.bacnkaccount.Entitiy.Account;
import com.ttech.bacnkaccount.Entitiy.Transaction;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/transactions")
    public List<Transaction> getAllTransaction(){
        return transactionService.showAllTransactions();
    }

    @GetMapping("/customers/{customerId}/{accountId}/transactions/{id}")
    public Transaction getTransaction(@PathVariable int id){
        return transactionService.getTransaction(id);
    }

    @PostMapping("/customers/{customerId}/{accountId}/new-transaction")
    public void makeNewTransaction(@RequestBody Transaction newTransaction, @PathVariable int customerId, @PathVariable int accountId){
        Account accountOfTransaction = accountService.getAccount(accountId);
        newTransaction.setAccount(accountOfTransaction);
        System.out.println(newTransaction.getAccount().getId());
        accountService.updateBalance(newTransaction.getAccount(),newTransaction.getAmount());
        transactionService.addTransaction(newTransaction);

    }
}