package com.db.javito.dao;

import com.db.javito.dao.interf.MainDao;
import com.db.javito.model.Main;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    public JSONArray getDataPeriod(String fromData, String toData) throws ParseException, JSONException {
        JSONObject jData = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH");
        Date fromDateObject = format.parse(fromData);
        Date toDateObject = format.parse(toData);
        String sql = "SELECT * FROM main";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
        List<Main> result = new ArrayList<Main>();
        for (Map<String, Object> row : rows) {
            Main main = new Main();
            Date current = format.parse((String) row.get("time"));
            if (current.after(fromDateObject) && current.before(toDateObject)) {
                JSONObject jElement = new JSONObject();
                jElement.put("id", String.valueOf(row.get("id")));
                jElement.put("time", String.valueOf(row.get("time")));
                jElement.put("usd", String.valueOf(row.get("usd_rate")));
                jElement.put("gbp", String.valueOf(row.get("gbp_rate")));
                jElement.put("eur", String.valueOf(row.get("eur_rate")));
                jsonArray.put(jElement);
            }
        }
        //jData.put("data", jsonArray);
        //jData.put(jsonArray);
        //jData.put(jsonArray);
        return jsonArray;
    }
}
