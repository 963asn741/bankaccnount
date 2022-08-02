package com.ttech.bacnkaccount.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ttech.bacnkaccount.Entitiy.User;
import com.ttech.bacnkaccount.JPA.UserRepo;
 
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserRepo userRepository;
     
    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        User user = userRepository.getUserByUsername(username);
         
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
         
        return new MyUserDetails(user);
    }
 
}