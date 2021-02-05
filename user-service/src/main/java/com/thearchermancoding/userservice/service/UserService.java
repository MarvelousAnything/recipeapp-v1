package com.thearchermancoding.userservice.service;

import com.thearchermancoding.userservice.model.User;
import com.thearchermancoding.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public void update(User user) {
        repository.save(user);
    }

    public User create(User user) {
        return repository.save(user);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void delete(User user) {
        repository.delete(user);
    }

}
