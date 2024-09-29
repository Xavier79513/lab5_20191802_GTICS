package com.example.lab5.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPacientes", nullable = false)
    private Integer id;

    @Column(name = "nombrePaciente", length = 45)
    private String nombrePaciente;

    @Column(name = "DNI", length = 45)
    private String dni;

    @Column(name = "Edad")
    private Integer edad;

}