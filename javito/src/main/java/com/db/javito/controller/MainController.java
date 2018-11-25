package com.db.javito.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    String hello() {
        return "Hello! We are Javito team. We are cool!";
    }
}
