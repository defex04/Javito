package com.db.javito.model;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
public class Main implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    String time;
    Float usd_rate;
    Float gbp_rate;
    Float eur_rate;

    @Override
    public String toString() {
        return "Id " + id + " time " + time + " USD: " + usd_rate +
        " GBP: " + gbp_rate + " EUR: " + eur_rate;
    }
}
