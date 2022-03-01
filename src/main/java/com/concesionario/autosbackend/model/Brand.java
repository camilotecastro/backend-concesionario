package com.concesionario.autosbackend.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "brand", fetch = FetchType.EAGER)
    private Set<Model> models = new HashSet<>();
}
