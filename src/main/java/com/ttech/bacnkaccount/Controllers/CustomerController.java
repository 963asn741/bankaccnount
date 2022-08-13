package com.ttech.bacnkaccount.Controllers;

import com.ttech.bacnkaccount.Entitiy.Customer;
import com.ttech.bacnkaccount.Entitiy.User;
import com.ttech.bacnkaccount.JPA.UserRepo;

import java.security.Principal;
import java.util.Optional;

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
    MyUserDetailsService userDetailsService;

    @Autowired
    UserRepo userRepo;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AccountService accountService;

    @GetMapping("/admin/customers")
    public String getList(Model model) {
        model.addAttribute("listcustomers", customerService.getAllCustomers());
        return "listofcustomers";
    }

    @GetMapping("/customers/{id}")
    public String getCustomer(@PathVariable int id, Model model) {
        model.addAttribute("listaccounts", accountService.getAccountsByCustomerId(id));
        model.addAttribute("listaccountssize", accountService.getAccountsByCustomerId(id).size());
        model.addAttribute("customer", customerService.getCustomer(id));
        model.addAttribute("condition", accountService.getAccountsByCustomerId(id).size() == 0);
        return "customerdetails";
    }

    @GetMapping("/customers/profile")
    public String getProfile(Model model, Principal principal) {
        User currentUser = userRepo.findUserByUsername(principal.getName());
        int id = currentUser.getCustomer().getId();
        model.addAttribute("listaccounts", accountService.getAccountsByCustomerId(id));
        model.addAttribute("listaccountssize", accountService.getAccountsByCustomerId(id).size());
        model.addAttribute("customer", customerService.getCustomer(id));
        model.addAttribute("condition", accountService.getAccountsByCustomerId(id).size() == 0);
        return "customerdetails";
    }

    @GetMapping("/admin/add-customer")
    public String addCustomerPage(Model model) {
        model.addAttribute("user", new User());
        return "addcustomerpage";
    }

    @PostMapping("/admin/add-customer-post")
    public String addCustomerToTable(@ModelAttribute User newUser) {
        if (!userRepo.findByUsername(newUser.getUsername()).equals(Optional.empty())) return "redirect:/admin/add-customer?badusername";
        else if(newUser.getUsername().equals("")) return "redirect:/admin/add-customer?emptyusername";
        else if(newUser.getPassword().equals("")) return "redirect:/admin/add-customer?emptypassword";
        else{
            Customer newCustomer = new Customer(newUser.getName());
            customerService.addCustomer(newCustomer);
            newUser.setActive(true);
            newUser.setCustomer(newCustomer);
            newUser.setRoles("ROLE_USER");
            userRepo.save(newUser);
            return "redirect:/";
        }
    }
}