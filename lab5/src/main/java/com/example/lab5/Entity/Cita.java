package com.example.lab5.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Citas")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCitas", nullable = false)
    private Integer id;

    @Column(name = "motivoConsulta", nullable = false, length = 45)
    private String motivoConsulta;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente idPaciente;

    @ManyToOne
    @JoinColumn(name = "idArea", nullable = false)
    private Area idArea;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "idFechaConsulta", referencedColumnName = "idFechas", nullable = false),
            @JoinColumn(name = "idProfesional", referencedColumnName = "idProfesional", nullable = false)
    })
    private Fecha fechas;


    @ManyToOne
    @JoinColumn(name = "idSede", nullable = false)
    private Sede idSede;

    @ManyToOne
    @JoinColumn(name = "idRiesgo", nullable = false)
    private Riesgo idRiesgo;

    @Column(name = "precio", precision = 10)
    private BigDecimal precio;

}