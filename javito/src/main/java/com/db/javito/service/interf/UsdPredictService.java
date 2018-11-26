package com.db.javito.service.interf;

import com.db.javito.model.UsdPredict;

public interface UsdPredictService {
    void insert(UsdPredict usdPredict);

    String getById(Integer id);
}
