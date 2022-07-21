package com.ttech.bacnkaccount.Entitiy;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    private int id;
    private long customerId;
    private String name; 

    @OneToMany
    private List<Account> accounts;

    public Customer(){

    }

    public Customer(int id, long customerId, String name){
        this.id = id;
        this.customerId = customerId;
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setcustomerId(long customerId){
        this.customerId = customerId;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public long getCustomerId(){
        return this.customerId;
    }

    public String getCustomerName(){
        return this.name;
    }
}