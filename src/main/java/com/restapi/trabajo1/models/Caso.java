package com.restapi.trabajo1.models;
import java.util.*;
import java.io.*;
import lombok.*;
import jakarta.persistence.*;

@Entity
@Table(name = "casos")
public class Caso implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Getter
    @Setter
    private String descripcion;

//    @ManyToMany()
//    private List<Victima> victimas;

}
