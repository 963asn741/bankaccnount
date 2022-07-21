package com.ttech.bacnkaccount.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttech.bacnkaccount.JPA.AccountRepo;
import com.ttech.bacnkaccount.Entitiy.Account;

@Service
public class AccountService{

    @Autowired
    private AccountRepo AccountTable;

    public List<Account> getAllAccounts(){
        List<Account> accounts = new ArrayList<>();
        AccountTable.findAll().forEach(accounts::add);
        return accounts;
    }

    public Account getAccount(int id){
        return AccountTable.findById(id).get();
    }
    
    public void addAccount(Account account){
        AccountTable.save(account);
    }       

    public void updateAccountBalance(int id, int newAmount){
        Account accountToUpdate = getAccount(id);
        accountToUpdate.updateAccountBalance(newAmount);
    }
}