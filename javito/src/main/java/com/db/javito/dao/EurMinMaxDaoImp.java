package com.db.javito.dao;

import com.db.javito.dao.interf.EurMinMaxDao;
import com.db.javito.model.EurMinMax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class EurMinMaxDaoImp extends JdbcDaoSupport implements EurMinMaxDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(EurMinMax eurMinMax) {
        String sql = "INSERT INTO eur_min_max " +
                "(ID_DAY, EUR_MAX, EUR_MIN) VALUES (?, ?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql, eurMinMax.getIdDay(), eurMinMax.getEurMax(), eurMinMax.getEurMin());
    }

    @Override
    public String findById(Integer id) {
        return null;
    }
}
