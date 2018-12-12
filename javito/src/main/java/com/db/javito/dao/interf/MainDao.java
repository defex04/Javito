package com.db.javito.dao.interf;

import com.db.javito.model.Main;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.List;

public interface MainDao {
    void insert(Main main);

    String findById(Integer id);

    JSONArray getDataPeriod(String fromData, String toData) throws ParseException, JSONException;
}
