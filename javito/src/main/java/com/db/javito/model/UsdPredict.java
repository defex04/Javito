package com.db.javito.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class UsdPredict implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Float predict_val_usd;
    Boolean increase_decrease;

    @Override
    public String toString() {
        return "Id " + id + " predict_val_eur: " + predict_val_usd + " increase_decrease: " + increase_decrease;
    }
}
