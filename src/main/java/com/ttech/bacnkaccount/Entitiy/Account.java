package com.ttech.bacnkaccount.Entitiy;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int balance;

    @OneToMany
    private List<Transaction> transactions;

    private int customerId;

    @ManyToOne
    @JoinColumn(name = "customerId", referencedColumnName = "id", insertable = false, updatable = false)
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

    public int getCustomerId(){
        return this.customerId;
    }

    public Customer getCUstomer(){
        return this.customer;
    }

    public void setAccountId(int id){
        this.id = id;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void setAccountTransactions(List<Transaction> transactions){
        this.transactions = transactions;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }
}
