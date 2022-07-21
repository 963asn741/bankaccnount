package com.ttech.bacnkaccount.JPA;

import org.springframework.data.repository.CrudRepository;
import com.ttech.bacnkaccount.Entitiy.Customer;

public interface CustomerRepo extends CrudRepository<Customer,Integer>{
    
}
