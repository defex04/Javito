package com.db.javito.service;

import com.db.javito.dao.interf.EurPredictDao;
import com.db.javito.model.EurPredict;
import com.db.javito.service.interf.EurPredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EurPredictServiceImp implements EurPredictService {

    @Autowired
    EurPredictDao eurPredictDao;

    @Override
    public void insert(EurPredict eurPredict) {
        eurPredictDao.insert(eurPredict);
    }

    @Override
    public String getById(Integer id) {
        return null;
    }
}
