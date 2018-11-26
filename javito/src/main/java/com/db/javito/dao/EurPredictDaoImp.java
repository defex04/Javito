package com.db.javito.dao;

import com.db.javito.dao.interf.EurPredictDao;
import com.db.javito.model.EurPredict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class EurPredictDaoImp extends JdbcDaoSupport implements EurPredictDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(EurPredict eurPredict) {
        String sql = "INSERT INTO eur_predict " +
                "(PREDICT_VAL_EUR, INCREASE_DECREASE) VALUES (?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql, eurPredict.getPredict_val_eur(), eurPredict.getIncrease_decrease());
    }

    @Override
    public String findById(Integer id) {
        return null;
    }
}
