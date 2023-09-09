package com.restapi.trabajo1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "casos")
public class Caso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String nombre;

    @Column
    @Getter
    @Setter
    private String fecha;

    @Column
    @Getter
    @Setter
    private String descripcion;

    @OneToMany
    private Set<Victima> victimas = new HashSet<>();
}
