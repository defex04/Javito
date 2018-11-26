package com.db.javito.controller;

import com.db.javito.math_python.PythonMath;
import com.db.javito.model.Main;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static com.db.javito.JavitoApplication.mainService;

@RestController
@EnableAutoConfiguration
public class MainController {

    @RequestMapping("/")
    @ResponseBody
    String hello() {

        StringBuilder str = new StringBuilder();
        for (Main main : mainService.getAllData()) {
            str.append(main.toString());
        }
        return str.toString();
    }

    @GetMapping("/hello")
    public String greet() {
        return PythonMath.test;
    }
}
