package com.thearchermancoding.ratingservice.client;

import com.thearchermancoding.ratingservice.metadata.UserMetadata;
import com.thearchermancoding.ratingservice.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@FeignClient("USER-SERVICE")
public interface UserClient {
    @GetMapping(value = "/users")
    List<User> getUsers();

    @GetMapping(value = "/users/{id}")
    User getUserById(@PathVariable(value = "id") Long id);
}
