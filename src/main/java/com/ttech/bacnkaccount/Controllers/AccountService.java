package com.ttech.bacnkaccount.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttech.bacnkaccount.JPA.AccountRepo;
import com.ttech.bacnkaccount.Entitiy.Account;
import com.ttech.bacnkaccount.Entitiy.Customer;

@Service
public class AccountService{

    @Autowired
    private AccountRepo AccountTable;

    public List<Account> getAllAccounts(){
        List<Account> accounts = new ArrayList<>();
        AccountTable.findAll().forEach(accounts::add);
        return accounts;
    }

    public List<Account> getAccountsByCustomerId(int id){
        return AccountTable.findByCustomerId(id);
    }

    public Account getAccount(int id){
        return AccountTable.findById(id).get();
    }
    
    public void addAccount(Account account){
        AccountTable.save(account);
    }       

    public void updateBalance(Account accountToUpdate, int newAmount){
        int currentBalance = accountToUpdate.getBalance();
        currentBalance = currentBalance + newAmount;
        accountToUpdate.setBalance(currentBalance);
    }

    public void setOwner(Account account, Customer owner){
        account.setCustomer(owner);
        AccountTable.save(account);
    }
}