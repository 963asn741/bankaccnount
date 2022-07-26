package com.ttech.bacnkaccount.Controllers;

import com.ttech.bacnkaccount.Entitiy.Customer;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @GetMapping("/customers")
    public String getList(Model model){
        model.addAttribute("listcustomers", customerService.getAllCustomers());
        return "listofcustomers";
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    @GetMapping("/add-customer")
    public String addCustomerPage(Model model){
        model.addAttribute("customer", new Customer());
        return "addcustomerpage";
    }

    @PostMapping("/customers/add-customer")
    public String addCustomerToTable(@ModelAttribute Customer newCustomer){
        customerService.addCustomer(newCustomer);
        return "redirect:/main-menu";
    }
}