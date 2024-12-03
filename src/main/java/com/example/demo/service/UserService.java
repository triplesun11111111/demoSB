package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;
public interface UserService {
    List<User> getUsers();
    void saveUser(User user);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User getUser(Integer id);
}