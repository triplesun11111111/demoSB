package com.example.demo.service;


import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User getUser(Integer id) {
        return userDAO.getUser(id);
    }
}