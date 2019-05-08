package com.devsofthewest.iphone.service;

import com.devsofthewest.iphone.model.Article;
import com.devsofthewest.iphone.repositories.ArticleRepository;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.Random;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;

    String idUrl = "https://en.wikipedia.org/?curid=";
    String textUrl = "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&pageids=12354&redirects=true";


    //Gets a random article and generates an ID.
    public Boolean addRandArticle() {
        Document doc;
        Random rand = new Random();
        Long articleId = rand.nextLong()%10000;
        while(articleRepository.findById(articleId).isPresent())
        {
            articleId = rand.nextLong()%10000;
        }
        try {
            doc = Jsoup.connect(idUrl + articleId.toString()).get();
        } catch (IOException e) {
            return false;
        }
        Article article = new Article(doc.select("div[id=content]").first().toString(), articleId);
        articleRepository.save(article); // The result
        return true;
    }

    //manually add an article and generate a random id. Returns article ID
    public Long addArticle(String text)
    {
        Random rand = new Random();
        Long articleId = rand.nextLong()%10000;
        while(articleRepository.findById(articleId).isPresent())
        {
            articleId = rand.nextLong()%10000;
        }
        Article article = new Article(text,articleId);
        articleRepository.save(article);
        return articleId;
    }

    public Article getRandArticle()
    {
        //todo randomize
        return(articleRepository.findAll().iterator().next());
    }

    public Iterable<Article> getAllArticles() {
        return articleRepository.findAll();
    }

}