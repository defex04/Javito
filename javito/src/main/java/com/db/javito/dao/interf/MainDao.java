package com.db.javito.dao.interf;

import com.db.javito.model.Main;

import java.util.List;

public interface MainDao {
    void insert(Main main);

    String findById(Integer id);

    List<Main> getAllData();
}
