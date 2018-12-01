package com.db.javito.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class UsdIdPredict implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Integer idUsd;
    Integer idPredict;

    @Override
    public String toString() {
        return "Id " + id + " id_usd: " + idUsd + " id_predict: " + idPredict;
    }
}
