package com.db.javito.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class EurIdPredict implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Integer idEur;
    Integer idPredict;

    @Override
    public String toString() {
        return "Id " + id + " id_eur: " + idEur + " id_predict: " + idPredict;
    }
}
