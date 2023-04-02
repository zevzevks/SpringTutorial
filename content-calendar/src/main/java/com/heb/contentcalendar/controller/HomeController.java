package com.heb.contentcalendar.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @Value("${cc.welcomeMessage: Default Welcome Message}")
    private String welcomeMsg;
    @GetMapping("/")
    public String home(){
        return welcomeMsg;
    }

}
