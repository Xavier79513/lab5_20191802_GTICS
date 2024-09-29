package com.example.lab5.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Fechas")
public class Fecha {
    @EmbeddedId
    private FechaId id;

    @Column(name = "fechaDisponibilidad", nullable = false)
    private LocalDate fechaDisponibilidad;

}