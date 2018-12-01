package com.db.javito.service.interf;

import com.db.javito.model.UsdIdPredict;

public interface UsdIdPredictService {
    void insert(UsdIdPredict usdIdPredict);

    String getById(Integer id);
}
