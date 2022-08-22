package com.ttech.bacnkaccount.Controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ttech.bacnkaccount.Entitiy.User;
import com.ttech.bacnkaccount.JPA.UserRepo;

import javax.annotation.PostConstruct;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin";

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepo.findByUsername(username);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: "+ username));
        return user.map(MyUserDetails::new).get();
    }

    @PostConstruct
    public void checkAdmin(){
        System.out.println("Running check for admin user");
        if (userRepo.findByUsername("admin").isEmpty()){
            User admin = new User();
            admin.setUsername(USERNAME);
            admin.setPassword(PASSWORD);
            admin.setActive(true);
            admin.setId(1);
            admin.setRoles("ROLE_ADMIN");
            admin.setName("Admin");
            userRepo.save(admin);
            System.out.println("Admin user added");
        }
        else System.out.println("Admin user already exists");
    }
}