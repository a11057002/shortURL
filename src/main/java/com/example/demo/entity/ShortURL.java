package com.example.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.Date;

@Document
public class ShortURL {


    @Id
    private String id;

    @Indexed(expireAfterSeconds = 3600)
    private Date  createAt;

    private String originalURL;
    private String sURL;

//    public ShortURL(String originalURL, String sURL) {
//        this.originalURL = originalURL;
//        this.sURL = sURL;
//    }

    public String getOriginalURL() {
        return originalURL;
    }

    public void setOriginalURL(String originalURL) {
        this.originalURL = originalURL;
    }

    public String getsURL() {
        return sURL;
    }

    public void setsURL(String sURL) {
        this.sURL = sURL;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setDelete(){
        this.createAt = Date.from(Instant.now());
    }
}
