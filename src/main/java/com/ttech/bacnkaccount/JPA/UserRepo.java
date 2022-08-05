package com.ttech.bacnkaccount.JPA;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ttech.bacnkaccount.Entitiy.*;;

public interface UserRepo extends JpaRepository<User, Integer>{
    Optional<User> findByUsername(String username);

    User findUserByUsername(String username);
}
