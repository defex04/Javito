package com.db.javito.dao.interf;

import com.db.javito.model.EurMinMax;

public interface EurMinMaxDao {
    void insert(EurMinMax eurMinMax);

    String findById(Integer id);
}
