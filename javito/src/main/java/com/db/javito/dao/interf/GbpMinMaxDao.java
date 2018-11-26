package com.db.javito.dao.interf;

import com.db.javito.model.GbpMinMax;

public interface GbpMinMaxDao {
    void insert(GbpMinMax gbpMinMax);

    String findById(Integer id);
}
