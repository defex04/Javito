package com.db.javito.dao;

import com.db.javito.dao.interf.EurIdPredictDao;
import com.db.javito.model.EurIdPredict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class EurIdPredictDaoImp extends JdbcDaoSupport implements EurIdPredictDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(EurIdPredict eurIdPredict) {
        String sql = "INSERT INTO eur_id_predict " +
                "(ID_EUR, ID_PREDICT) VALUES (?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql, eurIdPredict.getIdEur(), eurIdPredict.getIdPredict());
    }

    @Override
    public String findById(Integer id) {
        return null;
    }
}
