package com.damithtech.springbootbasic.controller;

import com.damithtech.springbootbasic.model.User;
import com.damithtech.springbootbasic.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author DAMITH SAMARAKOON on 7/24/2020
 */
@RestController
public class UserController {

    @Autowired
    private UserDaoService userDaoService;

    @GetMapping(value = "/getAllUsers")
    public List<User> getAllUsers() {
        return userDaoService.findAllUsers();
    }

    @GetMapping(value = "/getAllUsers/{id}")
    public User getUser(@PathVariable int id) {
        return userDaoService.findOneUser(id);
    }

    @PostMapping(value = "/saveUser")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saveUser = userDaoService.saveUser(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                saveUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}