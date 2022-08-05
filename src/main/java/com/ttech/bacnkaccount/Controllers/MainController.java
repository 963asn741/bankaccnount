package com.ttech.bacnkaccount.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMainMenu(){
        return "mainmenu";
    }
}