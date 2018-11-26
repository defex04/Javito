package com.db.javito.service;

import com.db.javito.dao.interf.EurMinMaxDao;
import com.db.javito.model.EurMinMax;
import com.db.javito.service.interf.EurMinMaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EurMinMaxServiceImp implements EurMinMaxService {
    @Autowired
    EurMinMaxDao eurMinMaxDao;

    @Override
    public void insert(EurMinMax eurMinMax) {
        eurMinMaxDao.insert(eurMinMax);
    }

    @Override
    public String getById(Integer id) {
        return null;
    }
}
