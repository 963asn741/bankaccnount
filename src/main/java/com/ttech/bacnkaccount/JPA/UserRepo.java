package com.ttech.bacnkaccount.JPA;

import org.springframework.data.repository.CrudRepository;

import com.ttech.bacnkaccount.Entitiy.User;

public interface UserRepo extends CrudRepository<User, Integer>{

    public User getUserByUsername(String username);
    
    
}