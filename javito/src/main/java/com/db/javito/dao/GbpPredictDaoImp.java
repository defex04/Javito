package com.db.javito.dao;

import com.db.javito.dao.interf.GbpPredictDao;
import com.db.javito.model.GbpPredict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class GbpPredictDaoImp extends JdbcDaoSupport implements GbpPredictDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(GbpPredict gbpPredict) {
        String sql = "INSERT INTO gbp_predict " +
                "(PREDICT_VAL_gbp, INCREASE_DECREASE) VALUES (?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql, gbpPredict.getPredict_val_gbp(), gbpPredict.getIncrease_decrease());
    }

    @Override
    public String findById(Integer id) {
        return null;
    }
}
