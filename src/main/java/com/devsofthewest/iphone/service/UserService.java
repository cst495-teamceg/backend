package com.devsofthewest.iphone.service;

import com.devsofthewest.iphone.model.User;
import com.devsofthewest.iphone.model.UserContext.*;
import com.devsofthewest.iphone.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository UserRepository;

    //todo set this up to be an actual token rather than a starter method
    //returns the userId if valid, otherwise returns -1.
    public String auth(UserAuth auth)
    {
        Optional<User> user = UserRepository.findById(auth.username);
        if(user.isPresent() && user.get().getPassword().equals(auth.password))
            return user.get().getUsername();
        return "Error";
    }

    public void addUser(User user)
    {
        UserRepository.save(user);
    }

    public Iterable<User> getAllUsers() {
        return UserRepository.findAll();
    }

    public Integer addXp(String username, int XP)
    {
        Optional<User> optUser = UserRepository.findById(username);
        if(!optUser.isPresent())
            return -1;
        
        User user = optUser.get();
        user.setExperience(user.getExperience() + XP);
        
        //Checking if level up
        if(user.getExperience() >= user.getLevel() * 50)
        {
            user.setLevel(user.getLevel() + 1);
        }
        UserRepository.save(user);
        return(user.getLevel());
    }

    public void addArticle(String username,Integer articleId)
    {
        Optional<User> optUser = UserRepository.findById(username);
        if(!optUser.isPresent())
            return;
        
        User user = optUser.get();
        user.AddArticle(articleId);
        UserRepository.save(user);
    }

}