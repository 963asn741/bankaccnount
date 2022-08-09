package com.ttech.bacnkaccount.Controllers;

import java.security.Principal;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ttech.bacnkaccount.Entitiy.Account;
import com.ttech.bacnkaccount.Entitiy.Customer;

@Controller
public class AccountController {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/admin/accounts")
    public String getAllExistingAccounts(Model model){
        model.addAttribute("listaccounts", accountService.getAllAccounts());
        return "listofaccountpage";
    }

    @GetMapping("/customers/accounts/{id}")
    public String getAccountDetails(Model model, @PathVariable int id){
        Account account = accountService.getAccount(id);
        Customer customer = customerService.getCustomer(account.getCustomerId());
        model.addAttribute("account", account);
        model.addAttribute("customer", customer);
        model.addAttribute("transactionlist", transactionService.getTransactionsOfAccount(id));
        model.addAttribute("condition", transactionService.getTransactionsOfAccount(id).size()==0);
        return "accountdetails";
    }

    @GetMapping("/admin/add-account")
    public String addCustomerPage(Model model){
        model.addAttribute("account", new Account());
        model.addAttribute("customerlist", customerService.getAllCustomers());
        for(Customer c : customerService.getAllCustomers()) System.out.println(c.getName());
        return "addaccountpage";
    }

    @PostMapping("/admin/add-account-post")
    public String addNewAccount(@ModelAttribute Account newAccount){
        Customer owner = customerService.getCustomer(newAccount.getCustomerId());
        accountService.setOwner(newAccount, owner);
        accountService.addAccount(newAccount);
        return "redirect:/";
    }
}