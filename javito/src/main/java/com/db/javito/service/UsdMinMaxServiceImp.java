package com.db.javito.service;

import com.db.javito.dao.interf.UsdMinMaxDao;
import com.db.javito.model.UsdMinMax;
import com.db.javito.service.interf.UsdMinMaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsdMinMaxServiceImp implements UsdMinMaxService {
    @Autowired
    UsdMinMaxDao usdMinMaxDao;
    @Override
    public void insert(UsdMinMax usdMinMax) {
        usdMinMaxDao.insert(usdMinMax);
    }

    @Override
    public String getById(Integer id) {
        return null;
    }
}
