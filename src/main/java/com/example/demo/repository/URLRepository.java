package com.example.demo.repository;

import com.example.demo.entity.ShortURL;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLRepository extends MongoRepository<ShortURL,String> {
    ShortURL findBysURL(String sURL);
}
