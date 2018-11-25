package com.db.javito.scheduler;

import com.db.javito.api.CoinDeskImp;
import com.db.javito.model.EurPredict;
import com.db.javito.model.Main;
import org.json.JSONException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.db.javito.JavitoApplication.eurPredictService;
import static com.db.javito.JavitoApplication.mainService;

@Component
public class Scheduler {

    // https://o7planning.org/ru/11131/running-background-scheduled-tasks-in-spring
    // Описание параметров фоновых задач

    @Scheduled(cron = "0 0 0/1 * * ?")
    public void loadData() throws IOException, JSONException {
        if (mainService != null) {
            Main main = new Main();
            CoinDeskImp coinDeskImp = new CoinDeskImp();
            coinDeskImp.getRealTimeBPI();
            main.setTime(coinDeskImp.getCurrentDate());
            main.setGbp_rate(coinDeskImp.getGbp());
            main.setEur_rate(coinDeskImp.getEur());
            main.setUsd_rate(coinDeskImp.getUsd());
            mainService.insert(main);
        }
    }

    @Scheduled(fixedRate = 36000)
    public void eurPredictLoadData() {
        if (eurPredictService != null) {
            EurPredict eurPredict = new EurPredict();
            eurPredict.setPredict_val_eur(30f);
            eurPredict.setIncrease_decrease(false);
            eurPredictService.insert(eurPredict);
        }
        System.out.println("EurPredict");
    }

    @Scheduled(fixedRate = 36000)
    public void clearTempFolder() {
        System.out.println("Timer works!");
    }
}
