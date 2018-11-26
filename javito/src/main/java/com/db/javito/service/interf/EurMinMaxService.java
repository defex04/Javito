package com.db.javito.service.interf;

import com.db.javito.model.EurMinMax;

public interface EurMinMaxService {
    void insert(EurMinMax eurMinMax);

    String getById(Integer id);
}
