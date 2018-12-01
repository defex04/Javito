package com.db.javito.service.interf;

import com.db.javito.model.EurIdPredict;

public interface EurIdPredictService {
    void insert(EurIdPredict eurIdPredict);

    String getById(Integer id);
}
