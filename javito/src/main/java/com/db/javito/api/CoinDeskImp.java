package com.db.javito.api;

import com.db.javito.api.interf.CoinDesk;
import lombok.Getter;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Getter
public class CoinDeskImp implements CoinDesk {

    private String currentDate;
    private float usd;
    private float gbp;
    private float eur;

    @Override
    public void getRealTimeBPI() throws IOException, JSONException {
        String response = sendRequest(API_URL + "currentprice.json");
        JSONObject obj = new JSONObject(response);
        JSONObject jsonBPI = obj.getJSONObject("bpi");
        JSONObject jsonUSD = jsonBPI.getJSONObject("USD");
        JSONObject jsonGBP = jsonBPI.getJSONObject("GBP");
        JSONObject jsonEUR = jsonBPI.getJSONObject("EUR");

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH");
        Date date = new Date();

        currentDate = dateFormat.format(date);
        usd = Float.valueOf(jsonUSD.getString("rate_float"));
        gbp = Float.valueOf(jsonGBP.getString("rate_float"));
        eur = Float.valueOf(jsonEUR.getString("rate_float"));
    }


    @Override
    public void getHistoricalBPI() {

    }

    @Override
    public void getHistoricalBPI(String currency) {

    }

    @Override
    public void getHistoricalBPI(String currency, Date start, Date end) {

    }

    @org.jetbrains.annotations.NotNull
    private String sendRequest(String url) throws IOException {

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
