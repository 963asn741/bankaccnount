package com.ttech.bacnkaccount.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ttech.bacnkaccount.Entitiy.Account;
import com.ttech.bacnkaccount.Entitiy.Customer;
import com.ttech.bacnkaccount.Entitiy.Transaction;
import com.ttech.bacnkaccount.Entitiy.User;
import com.ttech.bacnkaccount.JPA.UserRepo;

@Controller
public class TransactionController {

    @Autowired
    UserRepo userRepo;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/add-transaction")
    public String addCustomerPage(Model model, Principal principal){
        User currentUser = userRepo.findUserByUsername(principal.getName());
        model.addAttribute("transaction", new Transaction());
        model.addAttribute("accountlist", accountService.getAccountsByCustomerId(currentUser.getCustomer().getId()));
        System.out.println(accountService.getAllAccounts().size());
        return "addtransactionspage";
    }

    @GetMapping("/customers/{accountId}/transactions/{id}")
    public String getAccountDetails(Model model, @PathVariable int accountId, @PathVariable int id){
        Account account = accountService.getAccount(accountId);
        Customer customer = customerService.getCustomer(account.getCustomerId());
        Transaction transaction = transactionService.getTransaction(id);
        model.addAttribute("account", account);
        model.addAttribute("customer", customer);
        model.addAttribute("transaction", transaction);
        return "transactiondetails";
    }

    @PostMapping("/customers/add-transaction-post")
    public String addCustomerToTable(@ModelAttribute Transaction newTransaction){
        Account accountOfTransaction = accountService.getAccount(newTransaction.getAccountId());
        newTransaction.setAccount(accountOfTransaction);
        accountService.updateBalance(newTransaction.getAccount(),newTransaction.getAmount());
        transactionService.addTransaction(newTransaction);        
        return "redirect:/";
    }
}