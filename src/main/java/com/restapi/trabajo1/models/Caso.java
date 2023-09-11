package com.restapi.trabajo1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
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

    @Size(min = 4, max = 50)
    @Getter
    @Setter
    @Column(nullable = false)
    private String nombre;

    @Getter
    @Setter
    @Column(nullable = false)
    private String fecha;

    @Getter
    @Setter
    @Column(nullable = false)
    @Size(min = 4, max = 150)
    private String descripcion;


    @OneToMany
    private Set<Victima> victimas = new HashSet<>();
}
