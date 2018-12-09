package com.db.javito.service;

import com.db.javito.dao.interf.MainDao;
import com.db.javito.model.Main;
import com.db.javito.service.interf.MainService;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

@Service
public class MainServiceImp implements MainService {

    @Autowired
    MainDao mainDao;

    @Override
    public void insert(Main main) {
        mainDao.insert(main);
    }

    @Override
    public String getById(Integer id) {
        return null;
    }

    @Override
    public JSONObject getDataPeriod(String fromData, String toData) throws ParseException, JSONException {

        return mainDao.getDataPeriod(fromData, toData);
    }
}
