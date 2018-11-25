package com.db.javito.service.interf;

import com.db.javito.model.Main;

import java.util.List;

public interface MainService {
    void insert(Main main);

    String getById(Integer id);

    List<Main> getAllData();
}
