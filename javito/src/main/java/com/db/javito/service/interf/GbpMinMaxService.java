package com.db.javito.service.interf;

import com.db.javito.model.GbpMinMax;

public interface GbpMinMaxService {
    void insert(GbpMinMax gbpMinMax);

    String getById(Integer id);
}
