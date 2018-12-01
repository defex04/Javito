package com.db.javito.service.interf;

import com.db.javito.model.Day;

public interface DayService {
    void insert(Day day);

    String getById(Integer id);
}
