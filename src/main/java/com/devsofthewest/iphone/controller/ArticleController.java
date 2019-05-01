package com.devsofthewest.iphone.controller;

import com.devsofthewest.iphone.service.ArticleService;
import com.devsofthewest.iphone.service.UserService;
import com.devsofthewest.iphone.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
public class ArticleController {


    @Autowired
    ArticleService articleService;

    @RequestMapping(method = RequestMethod.GET, value = "/articles/getRandom")
    @ApiOperation(value = "Gets a random article")
    public Article getRandom()
    {
        return(articleService.getRandArticle());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/articles/getAll")
    @ApiOperation(value = "Returns all articles")
    public Iterable<Article> users() {
        return articleService.getAllArticles();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/articles/addArticle")
    @ApiOperation(value = "Gets a random article from wikipedia, and adds it to the database")
    public void addArticle()
    {
        articleService.addRandArticle();
    }


}