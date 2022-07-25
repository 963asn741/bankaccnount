package com.ttech.bacnkaccount.Controllers;

import org.springframework.stereotype.Service;

import com.ttech.bacnkaccount.Entitiy.Admin;

@Service
public class AdminService {

    Admin admin = new Admin("admin", "adminn");
    
    public String username(){
        return admin.getUsername();
    }

    public String password(){
        return admin.getPassword();
    }
}
