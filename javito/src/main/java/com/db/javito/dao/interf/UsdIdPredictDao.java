package com.db.javito.dao.interf;

import com.db.javito.model.UsdIdPredict;

public interface UsdIdPredictDao {

    void insert(UsdIdPredict usdIdPredict);

    String findById(Integer id);
}
