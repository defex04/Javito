package com.db.javito.service.interf;

import com.db.javito.model.EurPredict;

public interface EurPredictService {
    void insert(EurPredict eurPredict);
    String getById(Integer id);
}
