package com.grocery_management.repository;

import com.grocery_management.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsUserByEmail(String email);
    Optional<User> findUserByEmail(String email);
}
