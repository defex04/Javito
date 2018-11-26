package com.db.javito.dao;

import com.db.javito.dao.interf.GbpMinMaxDao;
import com.db.javito.model.EurMinMax;
import com.db.javito.model.GbpMinMax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class GbpMinMaxDaoImp extends JdbcDaoSupport implements GbpMinMaxDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public void insert(GbpMinMax gbpMinMax) {
        String sql = "INSERT INTO gbp_min_max " +
                "(ID_DAY, GBP_MAX, GBP_MIN) VALUES (?, ?, ?)";
        assert getJdbcTemplate() != null;
        getJdbcTemplate().update(sql, gbpMinMax.getIdDay(), gbpMinMax.getGbpMax(), gbpMinMax.getGbpMin());
    }

    @Override
    public String findById(Integer id) {
        return null;
    }
}
