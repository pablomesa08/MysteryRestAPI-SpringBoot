package com.restapi.trabajo1.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "formas_asesinato")
public class FormaAsesinato implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    @Size(min = 4, max = 50)
    private String nombre;

    @OneToMany
    private Set<Victima> victimas = new HashSet<>();
}
