package com.db.javito;

import com.db.javito.model.EurPredict;
import com.db.javito.model.Main;
import com.db.javito.service.interf.EurPredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.db.javito.dao.interf.MainDao;
import com.db.javito.service.interf.MainService;

@SpringBootApplication
public class JavitoApplication {

    @Autowired
    public static MainService mainService;
    @Autowired
    public static EurPredictService eurPredictService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(JavitoApplication.class, args);
        System.out.println("Javito");

        mainService = context.getBean(MainService.class);
        eurPredictService = context.getBean(EurPredictService.class);

    }
}