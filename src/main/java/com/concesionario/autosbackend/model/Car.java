package com.concesionario.autosbackend.model;

import com.concesionario.autosbackend.enums.Color;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String version;
    private boolean isAutomatic;
    @Enumerated(EnumType.STRING)
    private Color color;
    private int km;
    @JsonIgnoreProperties("cars")
    @ManyToOne(optional = false)
    private Model model;

}
