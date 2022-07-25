package com.ttech.bacnkaccount.JPA;

import java.util.*;

import org.springframework.data.repository.CrudRepository;
import com.ttech.bacnkaccount.Entitiy.Customer;
import com.ttech.bacnkaccount.Entitiy.Account;

public interface CustomerRepo extends CrudRepository<Customer,Integer>{
}
