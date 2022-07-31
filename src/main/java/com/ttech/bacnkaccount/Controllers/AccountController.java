package com.ttech.bacnkaccount.Controllers;

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

    @GetMapping("/accounts")
    public String getAllExistingAccounts(Model model){
        model.addAttribute("listaccounts", accountService.getAllAccounts());
        return "listofaccountpage";
    }

    @GetMapping("/customers/{customerId}/accounts")
    public List<Account> getAllAccountOfCustomer(@PathVariable int customerId){
        return accountService.getAccountsByCustomerId(customerId);
    }

    @GetMapping("/customers/accounts/{id}")
    public String getAccountDetails(Model model, @PathVariable int id){
        Account account = accountService.getAccount(id);
        Customer customer = customerService.getCustomer(account.getCustomerId());
        System.out.println("REEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
        System.out.println(account.getCustomerId());
        System.out.println("REEETTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
        model.addAttribute("account", account);
        model.addAttribute("customer", customer);
        model.addAttribute("transactionlist", transactionService.getTransactionsOfAccount(id));
        model.addAttribute("condition", transactionService.getTransactionsOfAccount(id).size()==0);
        return "accountdetails";
    }

    @GetMapping("/add-account")
    public String addCustomerPage(Model model){
        model.addAttribute("account", new Account());
        model.addAttribute("customerlist", customerService.getAllCustomers());
        for(Customer c : customerService.getAllCustomers()) System.out.println(c.getName());
        return "addaccountpage";
    }

    @PostMapping("/customers/add-account")
    public String addNewAccount(@ModelAttribute Account newAccount){
        System.out.println("CUSTMER ID ="+newAccount.getCustomerId());
        Customer owner = customerService.getCustomer(newAccount.getCustomerId());
        System.out.println(owner.getName());
        accountService.setOwner(newAccount, owner);
        accountService.addAccount(newAccount);
        return "redirect:/main-menu";
    }
}