package com.example.lab5_20191802.Entity;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Pacientes")
public class Pacientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPaciente", nullable = false)
    private Integer idPaciente;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "edad", nullable = false)
    private Integer edad;

    @OneToMany(mappedBy = "paciente",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Citas> citas = new LinkedHashSet<>();

}
