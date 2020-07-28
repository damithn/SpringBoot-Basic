package com.damithtech.springbootbasic.controller;


import com.damithtech.springbootbasic.exception.UserNotFoundException;
import com.damithtech.springbootbasic.model.User;
import com.damithtech.springbootbasic.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public EntityModel<User> getUser(@PathVariable int id) {
        User user = userDaoService.findOneUser(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }

        //link to retreview all users insted of User
        //HATEOAS
        EntityModel<User> resource = EntityModel.of(user);
        ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(
                ControllerLinkBuilder.methodOn(this.getClass()).getAllUsers());
        resource.add(linkTo.withRel("all-users"));

        return resource;
    }


    //@valid annotation used for validate User variables -- javax.validation
    @PostMapping(value = "/saveUser")
    public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {
        User saveUser = userDaoService.saveUser(user);

        //get uri to location header
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(
                saveUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping(value = "/deleteUserById/{id}")
    public ResponseEntity deleteUserById(@PathVariable int id) {
        User user = userDaoService.DeleteUserById(id);
        if (user == null) {
            throw new UserNotFoundException("id-" + id);
        }
        //can remove ResponseEntity and just returned 200ok.
        return ResponseEntity.noContent().build();
    }
}