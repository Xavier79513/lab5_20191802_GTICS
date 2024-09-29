package com.example.lab5.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Profesionales")
public class Profesional {
    @Id
    @Column(name = "idProfesionales", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 45)
    private String nombre;

    @Column(name = "imagen", nullable = false, length = 45)
    private String imagen;

    @Column(name = "descripcionProfesional", nullable = false, length = 90)
    private String descripcionProfesional;

    @ManyToOne
    @JoinColumn(name = "idArea", nullable = false)
    private Area idArea;

    @ManyToOne
    @JoinColumn(name = "idSede", nullable = false)
    private Sede idSede;

}