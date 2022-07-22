package com.ttech.bacnkaccount.Controllers;

import com.ttech.bacnkaccount.Entitiy.Customer;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-all-customers")
    public List<Customer> getEveryCustomer(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/add-customer")
    public void addCustomerToTable(@RequestBody Customer newCustomer){
        customerService.addCustomer(newCustomer);
    }
}