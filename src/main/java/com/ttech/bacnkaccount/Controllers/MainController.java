package com.ttech.bacnkaccount.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ttech.bacnkaccount.Entitiy.Admin;

@Controller
public class MainController {

    @Autowired
    public AdminService adminService;

    @GetMapping("/")
    public String getMainMenu(){
        return "mainmenu";
    }
}