package com.devsofthewest.iphone.controller;

import com.devsofthewest.iphone.service.UserService;
import com.devsofthewest.iphone.model.*;
import com.devsofthewest.iphone.model.UserContext.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/user/get/{username}")
    @ApiOperation(value = "Gets a user with userId")
    public User getUser(@RequestParam String username)
    {
        return(userService.getUser(username));
    }

    

    @RequestMapping(method = RequestMethod.GET, value = "/user/getAll")
    @ApiOperation(value = "Returns all users")
    public Iterable<User> users() {
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/add")
    @ApiOperation(value = "Adds a user to the database")
    public String save(@RequestBody User user) {
        userService.addUser(user);

        //todo should return success? Is this right return?
        return user.getUsername();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/authenticate")    
    @ApiOperation(value = "Authenticates the user, returns the user ID, or -1 if invalid")
    public Integer authenticate(@RequestBody UserAuth auth) {
        return(userService.auth(auth));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/addXp")
    @ApiOperation(value = "Adds xp to the user, returns the level the user is after xp is added")
    public Integer addXp(@RequestBody UserXP userXP)
    {
        return(userService.addXp(userXP.username, userXP.xp));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/addReadArticle")
    @ApiOperation(value = "Adds xp to the user, returns the level the user is after xp is added")
    public void addArticle(@RequestBody UserArticle userArticle)
    {
        userService.addArticle(userArticle.username, userArticle.articleId);
    }
}

class UserArticle
{
    public String username;
    public Long articleId;
}
