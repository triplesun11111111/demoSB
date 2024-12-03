package com.example.demo.dao;
import com.example.demo.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getUsers();
    void saveUser(User user);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(Integer id);
    User getUser(Integer id);
}
