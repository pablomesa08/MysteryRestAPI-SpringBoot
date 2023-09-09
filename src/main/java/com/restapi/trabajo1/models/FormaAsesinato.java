package com.restapi.trabajo1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "formas_asesinato")
public class FormaAsesinato implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Column
    @Getter
    @Setter
    private String nombre;

    @OneToMany
    private Set<Victima> victimas = new HashSet<>();
}
