package com.ttech.bacnkaccount.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttech.bacnkaccount.Entitiy.Transaction;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @PostMapping("/new-transaction")
    public void makeNewTransaction(@RequestBody Transaction newTransaction){
        transactionService.addTransaction(newTransaction);
        accountService.updateAccountBalance(newTransaction.getId(),newTransaction.getAmountOfTransaction());
    }
}