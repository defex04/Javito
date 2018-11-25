package com.db.javito.dao;

import com.db.javito.dao.interf.MainDao;
import com.db.javito.model.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class MainDaoImp extends JdbcDaoSupport implements MainDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(Main main) {
        String sql = "INSERT INTO main " +
                "(TIME, USD_RATE, GBP_RATE, EUR_RATE) VALUES (?, ?, ?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql, main.getTime(), main.getUsd_rate(), main.getGbp_rate(),
                main.getEur_rate());
    }

    @Override
    public String findById(Integer id) {
        return null;
    }
}
