package com.restapi.trabajo1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "victimas")
public class Victima implements Serializable{
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
    private Integer edad;

    @Column
    @Getter
    @Setter
    private String sexo;

    @Column
    @Getter
    @Setter
    private String ocupacion;

    @Column
    @Getter
    @Setter
    private String lugarMuerte;

    @Column
    @Getter
    @Setter
    private String fechaMuerte;

    @ManyToOne
    @JoinColumn(name = "familia_id")
    @Getter
    @Setter
    private Familia familia;

    @ManyToOne
    @JoinColumn(name = "caso_id")
    @Getter
    @Setter
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "formaAsesinato_id")
    @Getter
    @Setter
    private FormaAsesinato formaAsesinato;
}
