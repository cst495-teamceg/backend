package com.devsofthewest.iphone.controller;

import com.devsofthewest.iphone.service.UserService;
import com.devsofthewest.iphone.model.*;
import com.devsofthewest.iphone.model.UserContext.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    @Autowired
    UserService userService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String test()
    {
        return "Hello";
    }

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

    @RequestMapping(method = RequestMethod.POST, value = "/users/authenticate")    
    public String authenticate(@RequestBody UserAuth auth) {
        //todo should return key if success for user.
        return userService.auth(auth);
    }
}