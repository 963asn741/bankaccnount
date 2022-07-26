package com.ttech.bacnkaccount.Controllers;

import com.ttech.bacnkaccount.Entitiy.Customer;

import java.lang.ProcessBuilder.Redirect;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<Customer> getEveryCustomer(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/customers/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }

    @GetMapping("/add-customer")
    public String addCustomerPage(){
        return "AddCustomer.html";
    }

    @PostMapping("/customers/add-customer")
    public String addCustomerToTable(@ModelAttribute Customer newCustomer){
        customerService.addCustomer(newCustomer);
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/list")
    public String getList(Model model){
        model.addAttribute("listcustomer",customerService.getAllCustomers());
        return "list-of-customers";
    }
   

}