package com.devsofthewest.iphone.model;

import org.springframework.cloud.gcp.data.datastore.core.mapping.Entity;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {


    @Id
    String username;
    String password;
    Integer classId;
    Integer level;
    long experience;
    List<Integer> readArticles;


    public User(String username, String password, Integer classId)
    {
        this.username = username;
        this.password = password;
        this.classId = classId;
        this.level = 1;
        this.experience = 0;
        List<Integer> readArticles = new ArrayList();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public long getExperience() {
        return experience;
    }

    public void setExperience(long experience) {
        this.experience = experience;
    }

    public List<Integer> getReadArticles() {
        return readArticles;
    }

    public void setReadArticles(List<Integer> readArticles) {
        this.readArticles = readArticles;
    }

    public void AddArticle(Integer articleId)
    {
        readArticles.add(articleId);
    }
}
