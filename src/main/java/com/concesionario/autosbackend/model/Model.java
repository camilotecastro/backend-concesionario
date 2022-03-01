package com.concesionario.autosbackend.model;


import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "brand_id")
    private Brand brand;
    @OneToMany(mappedBy = "model")
    private Set<Car> cars = new HashSet<>();

}
