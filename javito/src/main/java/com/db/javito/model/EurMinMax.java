package com.db.javito.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class EurMinMax implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    Integer idDay;
    Float eurMax;
    Float eurMin;

    @Override
    public String toString() {
        return "Id " + id + " id_day: " + idDay + " eur_max: " + eurMax + " eur_min: " + eurMin;
    }
}
