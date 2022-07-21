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
    private long transactionId;
    private int amount;
    
    @ManyToOne
    @JoinColumn(name = "transactionId", referencedColumnName = "id", insertable = false, updatable = false)
    public Account account;
    
    public Transaction(){
    }

    public Transaction(int id, long transactionId, Account account, int amount){
        this.id = id;
        this.transactionId = transactionId;
        this.amount = amount;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTransactionId(long transactionId){
        this.transactionId = transactionId;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public int getId(){
        return this.id;
    }

    public long getTransactionId(){
        return this.transactionId;
    }

    public int getAmountOfTransaction(){
        return this.amount;
    }
}
