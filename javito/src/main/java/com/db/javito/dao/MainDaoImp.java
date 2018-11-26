package com.db.javito.dao;

import com.db.javito.dao.interf.MainDao;
import com.db.javito.model.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<Main> getAllData() {
        String sql = "SELECT * FROM main";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<Main> result = new ArrayList<Main>();
        for (Map<String, Object> row : rows) {
            Main main = new Main();
            main.setId((Integer) row.get("id"));
            main.setTime((String) row.get("time"));
            main.setUsd_rate((Float) row.get("usd_rate"));
            main.setGbp_rate((Float) row.get("gbp_rate"));
            main.setEur_rate((Float) row.get("eur_rate"));
            result.add(main);
        }

        return result;
    }
}
