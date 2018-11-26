package com.db.javito.service;

import com.db.javito.dao.interf.GbpPredictDao;
import com.db.javito.model.GbpPredict;
import com.db.javito.service.interf.GbpPredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GbpPredictServiceImp implements GbpPredictService {

    @Autowired
    GbpPredictDao gbpPredictDao;
    @Override
    public void insert(GbpPredict gbpPredict) {
        gbpPredictDao.insert(gbpPredict);
    }

    @Override
    public String getById(Integer id) {
        return null;
    }
}
