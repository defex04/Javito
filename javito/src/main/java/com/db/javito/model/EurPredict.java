package com.db.javito.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class EurPredict implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Float predict_val_eur;
    Boolean increase_decrease;

    @Override
    public String toString() {
        return "Id " + id + " predict_val_eur: " + predict_val_eur + " increase_decrease: " + increase_decrease;
    }

}
