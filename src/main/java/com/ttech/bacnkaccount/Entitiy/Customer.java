package com.ttech.bacnkaccount.Entitiy;

import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name; 

    @OneToMany(mappedBy = "customer")
    private List<Account> accounts;

    public Customer(){
    }

    public Customer(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }
}