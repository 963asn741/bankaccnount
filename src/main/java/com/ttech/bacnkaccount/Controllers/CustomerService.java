package com.ttech.bacnkaccount.Controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ttech.bacnkaccount.JPA.CustomerRepo;
import com.ttech.bacnkaccount.Entitiy.Customer;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo CustomerTable;


    public List<Customer> getAllCustomers(){
        List<Customer> customers = new ArrayList<>();
        CustomerTable.findAll().forEach(customers::add);
        return customers;
    }

    public Customer getCustomer(int id){
        return CustomerTable.findById(id).get();
    }
    
    public void addCustomer(Customer newCustomer){
        CustomerTable.save(newCustomer);
    }          
}
