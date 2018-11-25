package com.db.javito.api.interf;

import org.json.JSONException;

import java.io.IOException;
import java.util.Date;

public interface CoinDesk {

    String API_URL = "https://api.coindesk.com/v1/bpi/";

    void getRealTimeBPI() throws IOException, JSONException;

    void getHistoricalBPI();

    void getHistoricalBPI(String currency);

    void getHistoricalBPI(String currency, Date start, Date end);
}
