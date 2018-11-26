package com.db.javito.dao.interf;

import com.db.javito.model.Day;

public interface DayDao {
    void insert(Day day);

    String findById(Integer id);
}
