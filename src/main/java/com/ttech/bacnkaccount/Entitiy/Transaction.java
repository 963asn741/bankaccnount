package com.ttech.bacnkaccount.Entitiy;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Transactions")
public class Transaction {
    @Id
    private int id;
    private int amount;
    
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

    public void setAccountOfTransaction(int accountId, int customerId){
        this.account = new Account(accountId, 0, customerId);
    }

    public int getId(){
        return this.id;
    }

    public int getAmountOfTransaction(){
        return this.amount;
    }

    public Account getAccountOfTransaction(){
        return this.account;
    }
}
