package com.example.demo.controller;


import com.example.demo.entity.ShortURL;
import com.example.demo.service.ShortURLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class ApiController {

    ShortURLService shortURLService;

    @Autowired
    public ApiController(ShortURLService shortURLService){
        this.shortURLService = shortURLService;
    }

    @PostMapping("/")
    public ResponseEntity<?> saveShortenURL(@RequestBody ShortURL shortURL){
        shortURL = shortURLService.saveURL(shortURL);
        return new ResponseEntity<>(shortURL, HttpStatus.OK);
    }


    @GetMapping("/getURL/{sURL}")
    public RedirectView getShortenURL(@PathVariable String sURL){
        return new RedirectView(shortURLService.getURL(sURL));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(shortURLService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/delete")
    public void deleteAll(){
        shortURLService.deleteAll();
    }

}
