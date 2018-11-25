package com.db.javito.dao.interf;

import com.db.javito.model.Main;

public interface MainDao {
    void insert(Main main);
    String findById(Integer id);
}
