package com.db.javito.service.interf;

import com.db.javito.model.Main;

public interface MainService {
    void insert(Main main);

    String getById(Integer id);
}
