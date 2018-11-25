package com.db.javito.scheduler;

import com.db.javito.model.Main;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static com.db.javito.JavitoApplication.mainService;

@Component
public class Scheduler {

    // https://o7planning.org/ru/11131/running-background-scheduled-tasks-in-spring
    // Описание параметров фоновых задач

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void loadData() {
        if (mainService != null) {
            Main main = new Main();
            main.setTime("2017");
            main.setGbp_rate(25.5f);
            main.setEur_rate(3523.5f);
            main.setUsd_rate(36.8f);
            mainService.insert(main);
        }
    }

    @Scheduled(fixedRate = 36000)
    public void clearTempFolder() {
        System.out.println("Timer works!");
    }
}
