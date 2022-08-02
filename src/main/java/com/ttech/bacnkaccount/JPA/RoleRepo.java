package com.ttech.bacnkaccount.JPA;

import org.springframework.data.repository.CrudRepository;

import com.ttech.bacnkaccount.Entitiy.Role;

public interface RoleRepo extends CrudRepository<Role, Integer>{
    
}
