package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/users")
    public String listUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "index";
    }

    @GetMapping("/users/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "create-user";
    }

    @PostMapping("/users")
    public String createUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id).orElse(null));
        return "edit-user";
    }

    @PostMapping("/users/{id}")
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/api/users")
    @ResponseBody
    public java.util.List<User> getAllUsersApi() {
        return userService.getAllUsers();
    }

    @GetMapping("/api/users/{id}")
    @ResponseBody
    public User getUserByIdApi(@PathVariable Long id) {
        return userService.getUserById(id).orElse(null);
    }

    @PostMapping("/api/users")
    @ResponseBody
    public User createUserApi(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/api/users/{id}")
    @ResponseBody
    public User updateUserApi(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/api/users/{id}")
    @ResponseBody
    public void deleteUserApi(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
