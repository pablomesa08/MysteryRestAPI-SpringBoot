package com.restapi.trabajo1.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "victimas")
public class Victima implements Serializable {
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
    private String apellido;

    @Column
    @Getter
    @Setter
    private Date fechaNacimiento;

    @Column
    @Getter
    @Setter
    private Date fechaDefuncion;

    @Column
    @Getter
    @Setter
    private String causaMuerte;


    @ManyToOne()
    private Familia familia;

    @ManyToMany()
    private List<Caso> casos;

    @ManyToMany
    private List<Familia> familias;


}
