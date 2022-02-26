package com.collegemart.repository;

import com.collegemart.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    boolean existsByUserName(String name);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    User findUserByEmail(String email);

    User findUserById(Long id);
}