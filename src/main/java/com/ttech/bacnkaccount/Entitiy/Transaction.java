package com.ttech.bacnkaccount.Entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private int accountId;

    @ManyToOne
    @JoinColumn(name = "accountId", referencedColumnName = "id", insertable = false, updatable = false)
    public Account account;
    
    public Transaction(){
    }

    public Transaction(int id, int amount, int accountID, int customerId){
        this.id = id;
        this.amount = amount;
        this.account = new Account(accountID, 0, customerId);
    }

    public void setId(int id){
        this.id = id;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public void setAccountId(int accountId){
        this.accountId = accountId;
    }

    public void setAccount(Account account){
        this.account = account;
    }

    public int getId(){
        return this.id;
    }

    public int getAccountId(){
        return this.accountId;
    }

    public int getAmount(){
        return this.amount;
    }

    public Account getAccount(){
        return this.account;
    }
}
