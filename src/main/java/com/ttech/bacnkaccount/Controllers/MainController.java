package com.ttech.bacnkaccount.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ttech.bacnkaccount.Entitiy.Admin;

@Controller
public class MainController {

    @Autowired
    public AdminService adminService;

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String loginPage() {
        return "login.html";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public String doLogin(@ModelAttribute(name = "adminform") Admin admin, Model m) {
        System.out.println(admin.getUsername());
        String uname = admin.getUsername();
        String pass = admin.getPassword();
        System.out.print(admin.getPassword());

        if (uname.equals(adminService.username()) && pass.equals(adminService.password())) {
            return "index";
        }
        m.addAttribute("error", "Incorrect Username & Password");
        return "login";
    }
}