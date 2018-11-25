package com.db.javito.dao.interf;

import com.db.javito.model.EurPredict;

public interface EurPredictDao {
    void insert(EurPredict eurPredict);
    String findById(Integer id);
}
