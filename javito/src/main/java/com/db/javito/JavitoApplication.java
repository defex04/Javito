package com.db.javito;

import com.db.javito.model.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.db.javito.dao.interf.MainDao;
import com.db.javito.service.interf.MainService;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
public class JavitoApplication {

    @Autowired
    public static MainService mainService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(JavitoApplication.class, args);
		System.out.println("Javito");

        mainService = context.getBean(MainService.class);

        Main main = new Main();
        main.setTime("2018");
        main.setGbp_rate(25.5f);
        main.setEur_rate(3523.5f);
        main.setUsd_rate(36.8f);

        //mainService.insert(main);

    }
}
