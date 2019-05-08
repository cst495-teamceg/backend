package com.devsofthewest.iphone.model;

public class ArticleWithString{
    public Long id;
    public String text;
    public Double rating;

    public ArticleWithString(Long id, String text, Double rating)
    {
        this.id = id;
        this.text = text;
        this.rating = rating;
    }
}