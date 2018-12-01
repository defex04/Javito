package com.db.javito.dao;

import com.db.javito.dao.interf.UsdIdPredictDao;
import com.db.javito.model.UsdIdPredict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class UsdIdPredictDaoImp extends JdbcDaoSupport implements UsdIdPredictDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(UsdIdPredict usdIdPredict) {
        String sql = "INSERT INTO eur_id_predict " +
                "(ID_EUR, ID_PREDICT) VALUES (?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql, usdIdPredict.getIdUsd(), usdIdPredict.getIdPredict());
    }

    @Override
    public String findById(Integer id) {
        return null;
    }
}
