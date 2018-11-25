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
    MainService mainService;
    EurPredictService eurPredictService;

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(JavitoApplication.class, args);
		System.out.println("Javito");
        MainService mainService = context.getBean(MainService.class);
        Main main = new Main();
        main.setTime("2018");
        main.setGbp_rate(25.5f);
        main.setEur_rate(3523.5f);
        main.setUsd_rate(36.8f);
        mainService.insert(main);

        EurPredictService eurPredictService = context.getBean(EurPredictService.class);
        EurPredict eurPredict = new EurPredict();
        eurPredict.setPredict_val_eur(44.3f);
        eurPredict.setIncrease_decrease(true);
        eurPredictService.insert(eurPredict);
    }
}
