package com.ttech.bacnkaccount.Controllers;

import com.ttech.bacnkaccount.Entitiy.Customer;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/get-all-customers")
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
}
