package com.db.javito.dao.interf;

import com.db.javito.model.UsdPredict;

public interface UsdPredictDao {
    void insert(UsdPredict usdPredict);
    String findById(Integer id);
}
