package com.db.javito.dao;

import com.db.javito.dao.interf.DayDao;
import com.db.javito.model.Day;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class DayDaoImp extends JdbcDaoSupport implements DayDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(Day day) {
        String sql = "INSERT INTO day " +
                "(ID_DAY) VALUES (?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql, day.getId_day());
    }

    @Override
    public String findById(Integer id) {
        return null;
    }
}
