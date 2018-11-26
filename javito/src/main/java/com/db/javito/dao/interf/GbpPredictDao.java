package com.db.javito.dao.interf;

import com.db.javito.model.GbpPredict;

public interface GbpPredictDao {
    void insert(GbpPredict dbpPredict);

    String findById(Integer id);
}
