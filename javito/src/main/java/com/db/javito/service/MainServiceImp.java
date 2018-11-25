package com.db.javito.service;

import com.db.javito.dao.interf.MainDao;
import com.db.javito.model.Main;
import com.db.javito.service.interf.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
