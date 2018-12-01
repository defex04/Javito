package com.db.javito.dao.interf;

import com.db.javito.model.EurIdPredict;

public interface EurIdPredictDao {

    void insert(EurIdPredict eurIdPredict);

    String findById(Integer id);
}
