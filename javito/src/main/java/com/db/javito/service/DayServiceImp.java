package com.db.javito.service;

import com.db.javito.dao.interf.DayDao;
import com.db.javito.model.Day;
import com.db.javito.service.interf.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayServiceImp implements DayService {
    @Autowired
    DayDao dayDao;

    @Override
    public void insert(Day day) {
        dayDao.insert(day);
    }

    @Override
    public String getById(Integer id) {
        return null;
    }
}
