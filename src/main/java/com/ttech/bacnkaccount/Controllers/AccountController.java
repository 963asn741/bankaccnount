package com.ttech.bacnkaccount.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.ttech.bacnkaccount.Entitiy.Account;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/get-accounts")
    public List<Account> getAllCustomers(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/get-accounts/{id}")
    public Account getAccountDetails(@PathVariable int id){
        return accountService.getAccount(id);
    }

    @PostMapping("/add-account")
    public void addNewAccount(@RequestBody Account newAccount){
        accountService.addAccount(newAccount);
    }
}