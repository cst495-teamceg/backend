package com.devsofthewest.iphone.controller;

import com.devsofthewest.iphone.service.UserService;
import com.devsofthewest.iphone.model.*;
import com.devsofthewest.iphone.model.UserContext.*;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/users/getAll")
    public Iterable<User> users() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/add")
    public String save(@RequestBody User user) {
        userService.addUser(user);

        //todo should return success? Is this right return?
        return user.getUsername();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users/authenticate")    public String authenticate(@RequestBody UserAuth auth) {
        //todo should return key if success for user.
        return userService.auth(auth);
    }
}