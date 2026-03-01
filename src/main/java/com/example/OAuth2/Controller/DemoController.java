package com.example.OAuth2.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/public")
    public String publicApi(){
        return "This is a Public API";
    }

    @GetMapping("/private")
    public String privateApi(){
        return "This is a private API";
    }
}
