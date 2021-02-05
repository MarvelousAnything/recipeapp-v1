package com.thearchermancoding.userservice.controller;

import com.thearchermancoding.userservice.model.User;
import com.thearchermancoding.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User createIngredient(@RequestBody User user) {
        return service.create(user);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public User getIngredient(@PathVariable("id") Long id) {
        return service.findById(id).orElse(null);
    }

    @GetMapping
    @ResponseBody
    public List<User> getAllIngredients() {
        return service.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
    }

}
