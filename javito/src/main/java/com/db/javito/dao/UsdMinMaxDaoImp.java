package com.db.javito.dao;

import com.db.javito.dao.interf.UsdMinMaxDao;
import com.db.javito.model.UsdMinMax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Repository
public class UsdMinMaxDaoImp extends JdbcDaoSupport implements UsdMinMaxDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
        public void insert(UsdMinMax usdMinMax) {
            String sql = "INSERT INTO usd_min_max " +
                    "(ID_DAY, USD_MAX, USD_MIN) VALUES (?, ?, ?)";
            assert getJdbcTemplate() != null;
            getJdbcTemplate().update(sql, usdMinMax.getIdDay(), usdMinMax.getUsdMax(), usdMinMax.getUsdMin());
    }

    @Override
    public String findById(Integer id) {
        return null;
    }
}
