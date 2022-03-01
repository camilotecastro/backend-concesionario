package com.concesionario.autosbackend.model;

import com.concesionario.autosbackend.enums.Color;

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
    @ManyToOne(optional = false)
    @JoinColumn()
    private Model model;

}
