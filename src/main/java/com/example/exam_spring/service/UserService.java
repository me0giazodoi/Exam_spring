package com.example.exam_spring.service;

import com.example.exam_spring.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.exam_spring.repositories.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user){
        return userRepository.findById(id)
                .map(p-> {
                    p.setName(user.getName());
                    p.setAge(user.getAge());
                    p.setSalary(user.getSalary());
                    return userRepository.save(p);
                })
                .orElseGet(()->{
                    user.setId(id);
                    return userRepository.save(user);
                });
    }

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<User> getUsersByName(String name) {
        return userRepository.findAllByNameContaining(name);
    }
}
