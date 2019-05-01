package com.devsofthewest.iphone.model;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.Generated;
import javax.persistence.GeneratedValue;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import com.google.cloud.datastore.StringValue;

@Entity(name = "articles")
public class Article {
    @Id
    Long id;
    StringValue text;
    Double rating;

    //Constructor for article. Sets rating to 3, and id is autogenerated.
    public Article(String text, Long id)
    {
        this.text = StringValue.newBuilder(text).setExcludeFromIndexes(true).build();
        this.rating = 3.0;
        this.id = id;
    }

}