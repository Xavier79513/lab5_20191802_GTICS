package com.example.lab5.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "profesionales")
public class Profesionales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfesionales;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "imagen")
    private String imagenUrl;

    @Column(name = "descripcionProfesional")
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "idArea", nullable = false)
    private Areas areas;

    @ManyToOne
    @JoinColumn(name = "idSede", nullable = false)
    private Sedes sedes;

}
