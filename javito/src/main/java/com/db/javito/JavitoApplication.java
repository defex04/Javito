package com.db.javito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.db.javito.service.interf.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
public class JavitoApplication {

    @Autowired
    public static MainService mainService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(JavitoApplication.class, args);
		System.out.println("Javito");

        mainService = context.getBean(MainService.class);

    }
}
