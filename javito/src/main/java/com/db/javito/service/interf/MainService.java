package com.db.javito.service.interf;

import com.db.javito.model.Main;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.List;

public interface MainService {
    void insert(Main main);

    String getById(Integer id);

    JSONArray getDataPeriod(String fromData, String toData) throws ParseException, JSONException;
}
