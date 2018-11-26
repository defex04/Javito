package com.db.javito.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class UsdMinMax implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Integer idDay;
    Float usdMax;
    Float usdMin;

    @Override
    public String toString() {
        return "Id " + id + " id_day: " + idDay + " gbp_max: " + usdMax + " gbp_min: " + usdMin;
    }
}
