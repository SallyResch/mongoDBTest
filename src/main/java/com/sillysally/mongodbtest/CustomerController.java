package com.sillysally.mongodbtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private int id;
    @GetMapping("/mongoTest")
    public String test(){
        return "<h1>Hello you MongoDB</h1>";
    }
}
