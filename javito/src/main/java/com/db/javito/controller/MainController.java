package com.db.javito.controller;

import com.db.javito.math_python.PythonMath;
import com.db.javito.model.Main;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;


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
    @CrossOrigin(origins = "http://localhost:3000")
    public String greet() {
        return PythonMath.test;
    }

    @RequestMapping(value="user", method = RequestMethod.GET)
    public @ResponseBody String getitem(@RequestParam("data") String itemid){
        String i = itemid;
        return i;
    }

    @PostMapping("/ha")
    @CrossOrigin(origins = "http://localhost")
    public String gt() {
        return "haha";
    }
}
