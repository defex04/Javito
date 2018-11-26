package com.db.javito.service.interf;

import com.db.javito.model.UsdMinMax;

public interface UsdMinMaxService {
    void insert(UsdMinMax usdMinMax);

    String getById(Integer id);
}
