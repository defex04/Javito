package com.db.javito.scheduler;

import com.db.javito.api.CoinDeskImp;
import com.db.javito.model.*;
import org.json.JSONException;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.db.javito.JavitoApplication.*;

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
    public void eurPredictLoadData(){
        if (eurPredictService != null) {
            EurPredict eurPredict = new EurPredict();
            eurPredict.setPredict_val_eur(30f);
            eurPredict.setIncrease_decrease(false);
            eurPredictService.insert(eurPredict);
        }
        System.out.println("EurPredict");
    }

    @Scheduled(fixedRate = 36000)
    public void usdPredictLoadData(){
        if (usdPredictService != null) {
            UsdPredict usdPredict = new UsdPredict();
            usdPredict.setPredict_val_usd(30f);
            usdPredict.setIncrease_decrease(false);
            usdPredictService.insert(usdPredict);
        }
        System.out.println("UsdPredict");
    }

    @Scheduled(fixedRate = 36000)
    public void gbpPredictLoadData(){
        if (gbpPredictService != null) {
            GbpPredict gbpPredict = new GbpPredict();
            gbpPredict.setPredict_val_gbp(30f);
            gbpPredict.setIncrease_decrease(false);
            gbpPredictService.insert(gbpPredict);
        }
        System.out.println("GbpPredict");
    }

    @Scheduled(fixedRate = 36000)
    public void dayLoadData(){
        if (dayService != null) {
            Day day = new Day();
            day.setIdDay(4);
            dayService.insert(day);
        }
        System.out.println("Day");
    }

    @Scheduled(fixedRate = 36000)
    public void eurMinMaxLoadData(){
        if (eurMinMaxService != null) {
            EurMinMax eurMinMax = new EurMinMax();
            eurMinMax.setIdDay(3);
            eurMinMax.setEurMax(34.5f);
            eurMinMax.setEurMin(22.2f);
            eurMinMaxService.insert(eurMinMax);
        }
        System.out.println("EurMinMax");
    }

    @Scheduled(fixedRate = 36000)
    public void clearTempFolder() {
        System.out.println("Timer works!");
    }
}
