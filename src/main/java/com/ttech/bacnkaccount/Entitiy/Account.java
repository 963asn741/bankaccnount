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
    private int balance;

    @OneToMany
    private List<Transaction> transactions;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id")
    public Customer customer;
    
    public Account(){

    }

    public Account(int id, int balance, int customerId){
        this.id = id;
        this.balance = balance;
        this.customer = new Customer(customerId, "");
    }

    public Account(int id, int balance, int customerId, List<Transaction> transactions){
        this.id = id;
        this.balance = balance;
        this.transactions = transactions;
        this.customer = new Customer(customerId, "");
    }

    public int getId(){
        return this.id;
    }

    public int getBalance(){
        return this.balance;
    }

    public void setAccountId(int id){
        this.id = id;
    }

    public void setAccountBalance(int newBalance){
        this.balance = newBalance;
    }

    public void setAccountTransactions(List<Transaction> transactions){
        this.transactions = transactions;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }
}
