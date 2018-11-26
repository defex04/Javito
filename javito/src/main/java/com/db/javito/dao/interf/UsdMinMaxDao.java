package com.db.javito.dao.interf;

import com.db.javito.model.UsdMinMax;

public interface UsdMinMaxDao {
    void insert(UsdMinMax usdMinMax);

    String findById(Integer id);
}
