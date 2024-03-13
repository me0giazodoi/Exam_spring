package com.example.exam_spring.repositories;

import com.example.exam_spring.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByNameContaining(String name);
}
