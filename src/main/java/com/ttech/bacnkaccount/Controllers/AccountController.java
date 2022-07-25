package com.ttech.bacnkaccount.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ttech.bacnkaccount.Entitiy.Account;
import com.ttech.bacnkaccount.Entitiy.Customer;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/accounts")
    public List<Account> getAllExistingAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/customers/{customerId}/accounts")
    public List<Account> getAllAccountOfCustomer(@PathVariable int customerId){
        return accountService.getAccountsByCustomerId(customerId);
    }

    @GetMapping("/customers/accounts/{id}")
    public Account getAccountDetails(@PathVariable int id){
        return accountService.getAccount(id);
    }

    @PostMapping("/customers/{customerId}/add-account")
    public void addNewAccount(@RequestBody Account newAccount, @PathVariable int customerId){
        Customer owner = customerService.getCustomer(customerId);
        System.out.println(owner.getName());
        accountService.setOwner(newAccount, owner);

        System.out.println(newAccount.customer.getId());
        accountService.addAccount(newAccount);
    }
}