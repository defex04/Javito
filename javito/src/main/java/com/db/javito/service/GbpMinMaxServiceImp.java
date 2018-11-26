package com.db.javito.service;

import com.db.javito.dao.interf.GbpMinMaxDao;
import com.db.javito.model.GbpMinMax;
import com.db.javito.service.interf.GbpMinMaxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class GbpMinMaxServiceImp implements GbpMinMaxService {

    @Autowired
    GbpMinMaxDao gbpMinMaxDao;

    @Override
    public void insert(GbpMinMax gbpMinMax) {
        gbpMinMaxDao.insert(gbpMinMax);
    }

    @Override
    public String getById(Integer id) {
        return null;
    }
}
