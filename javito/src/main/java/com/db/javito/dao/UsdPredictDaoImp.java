package com.db.javito.dao;

import com.db.javito.dao.interf.UsdPredictDao;
import com.db.javito.model.UsdPredict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class UsdPredictDaoImp extends JdbcDaoSupport implements UsdPredictDao {
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(UsdPredict usdPredict) {
        String sql = "INSERT INTO usd_predict " +
                "(PREDICT_VAL_USD, INCREASE_DECREASE) VALUES (?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql, usdPredict.getPredict_val_usd(), usdPredict.getIncrease_decrease());
    }

    @Override
    public String findById(Integer id) {
        return null;
    }
}
