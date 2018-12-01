package com.db.javito.service;

import com.db.javito.dao.interf.UsdIdPredictDao;
import com.db.javito.model.UsdIdPredict;
import com.db.javito.service.interf.UsdIdPredictService;
import org.springframework.beans.factory.annotation.Autowired;

public class UsdIdPredictServiceImp implements UsdIdPredictService {
    @Autowired
    UsdIdPredictDao usdIdPredictDao;

    @Override
    public void insert(UsdIdPredict usdIdPredict) {
        usdIdPredictDao.insert(usdIdPredict);
    }

    @Override
    public String getById(Integer id) {
        return null;
    }
}
