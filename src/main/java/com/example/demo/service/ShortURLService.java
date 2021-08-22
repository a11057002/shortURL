package com.example.demo.service;

import com.example.demo.entity.ShortURL;
import com.example.demo.repository.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortURLService {

    URLRepository urlRepository;

    @Autowired
    public ShortURLService(URLRepository urlRepository){
        this.urlRepository = urlRepository;
    }

    public ShortURL saveURL(ShortURL shortURL){
        String randomStr = "";
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        for(int i=0;i<10;i++){
            randomStr += characters.charAt((int)Math.floor(Math.random()*characters.length()));
        }
        shortURL.setsURL(randomStr);
        shortURL.setDelete();
        urlRepository.save(shortURL);
        return shortURL;
    }

    public String getURL(String sURL){
        ShortURL shortURL =  urlRepository.findBysURL(sURL);
        return shortURL.getOriginalURL();
    }


    public List<ShortURL> getAll(){
        return urlRepository.findAll();
    }

    public void deleteAll(){
        urlRepository.deleteAll();
    }

}
