package com.example.lab5_20191802.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "citas")
public class Citas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCita", nullable = false)
    private Integer idCita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disponibilidad_id")
    private Disponibilidad disponibilidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profesional_id")
    private Profesionales profesional;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id")
    private Pacientes paciente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "riesgo_id")
    private Riesgos riesgo;

    @Column(name = "motivo_consulta", nullable = false, length = 150)
    private String motivoConsulta;

    @Column(name = "precio", nullable = false)
    private BigDecimal precio;
}