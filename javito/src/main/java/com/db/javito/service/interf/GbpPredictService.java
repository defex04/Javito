package com.db.javito.service.interf;

import com.db.javito.model.GbpPredict;

public interface GbpPredictService {
    void insert(GbpPredict gbpPredict);

    String getById(Integer id);
}
