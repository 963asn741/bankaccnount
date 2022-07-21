package com.ttech.bacnkaccount.Entitiy;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    private int id;
    private long accountNumber;
    private int balance;

    @OneToMany
    private List<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id", insertable = false, updatable = false)
    public Customer customer;
    
    public Account(){

    }

    public Account(int id, long accountNumber, int balance, List<Transaction> transactions){
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = transactions;
    }

    public int getId(){
        return this.id;
    }

    public long getAccountNumber(){
        return this.accountNumber;
    }

    public int getAccoutnBalance(){
        return this.balance;
    }

    public List<Transaction> getAllTransactions(){
        return this.transactions;
    }

    public void setAccountId(int id){
        this.id = id;
    }

    public void setAccountNumber(long accountNumber){
        this.accountNumber = accountNumber;
    }

    public void updateAccountBalance(int newBalance){
        this.balance = newBalance;
    }

    public void setAccountTransactions(List<Transaction> transactions){
        this.transactions = transactions;
    }
}
