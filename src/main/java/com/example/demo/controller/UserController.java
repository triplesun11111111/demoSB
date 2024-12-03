package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String index(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/new")
    public String addUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/users/edit")
    public String showEditForm(@RequestParam("id") Integer id, Model model) {
        User user = userService.getUsers().stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
        if (user != null) {
            model.addAttribute("user", user);
        }
        return "edit";
    }

    @PostMapping("/users/edit")
    public String updateUser(@RequestParam("id") Integer id, @ModelAttribute User user) {
        User existingUser = userService.getUser(id);
        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setAge(user.getAge());
        userService.updateUser(existingUser);
        return "edit";
    }


    @PostMapping("/users/delete")
    public String deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}

