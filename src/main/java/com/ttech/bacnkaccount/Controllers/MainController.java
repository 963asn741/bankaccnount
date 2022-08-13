package com.ttech.bacnkaccount.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMainMenu(){
        return "mainmenu";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/access-denied")
    public String forbidden(){
        return "access-denied";
    }
}