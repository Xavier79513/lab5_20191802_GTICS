package com.example.lab5_20191802.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Profesionales")
public class Profesionales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProfesional")
    private Integer idProfesional;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "imagen", nullable = false, length = 150)
    private String imagen;

    @Column(name = "descripcion", nullable = false, length = 150)
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "area_id", nullable = false)
    private Areas area;

    @ManyToOne
    @JoinColumn(name = "sede_id", nullable = false)
    private Sedes sede;

    @OneToMany(mappedBy = "profesional",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Citas> citas = new LinkedHashSet<>();

    @OneToMany(mappedBy = "profesional",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Disponibilidad> disponibilidads = new LinkedHashSet<>();

}
