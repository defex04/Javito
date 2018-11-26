package com.db.javito.service;

import com.db.javito.dao.interf.UsdPredictDao;
import com.db.javito.model.UsdPredict;
import com.db.javito.service.interf.UsdPredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsdPredictServiceImp implements UsdPredictService {
    @Autowired
    UsdPredictDao usdPredictDao;

    @Override
    public void insert(UsdPredict usdPredict) {
        usdPredictDao.insert(usdPredict);
    }

    @Override
    public String getById(Integer id) {
        return null;
    }
}
