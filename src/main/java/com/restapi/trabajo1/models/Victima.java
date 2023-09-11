package com.restapi.trabajo1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "victimas")
public class Victima implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false)
    @Getter
    @Setter
    private String nombre;

    @Column(nullable = false)
    @Getter
    @Setter
    private String apellido;

    @Column(nullable = false)
    @Getter
    @Setter
    private Integer edad;

    @Column(nullable = false)
    @Getter
    @Setter
    private String sexo;

    @Column(nullable = false)
    @Getter
    @Setter
    private String ocupacion;

    @Column(nullable = false)
    @Getter
    @Setter
    private String lugarMuerte;

    @Column(nullable = false)
    @Getter
    @Setter
    private String fechaMuerte;

    @ManyToOne
    @JoinColumn(name = "familia_id", nullable = false)
    @Getter
    @Setter
    private Familia familia;

    @ManyToOne
    @JoinColumn(name = "caso_id", nullable = false)
    @Getter
    @Setter
    private Caso caso;

    @ManyToOne
    @JoinColumn(name = "formaAsesinato_id", nullable = false)
    @Getter
    @Setter
    private FormaAsesinato formaAsesinato;
}
