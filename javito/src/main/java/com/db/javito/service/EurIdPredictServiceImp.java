package com.db.javito.service;

import com.db.javito.dao.interf.EurIdPredictDao;
import com.db.javito.model.EurIdPredict;
import com.db.javito.service.interf.EurIdPredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EurIdPredictServiceImp implements EurIdPredictService {
    @Autowired
    EurIdPredictDao eurIdPredictDao;

    @Override
    public void insert(EurIdPredict eurIdPredict) {
        eurIdPredictDao.insert(eurIdPredict);
    }

    @Override
    public String getById(Integer id) {
        return null;
    }
}
