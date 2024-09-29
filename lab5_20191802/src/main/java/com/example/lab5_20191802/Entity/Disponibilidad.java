package com.example.lab5_20191802.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Disponibilidad")
public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDisponibilidad")
    private Integer idDisponibilidad;

    @ManyToOne
    @JoinColumn(name = "profesional_id")
    private Profesionales profesional;

    @Column(name = "fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "disponible")
    private Boolean disponible;

    @OneToMany(mappedBy = "disponibilidad",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Citas> citas = new LinkedHashSet<>();

}
