package com.example.lab5.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "riesgos")
public class Riesgo {
    @Id
    @Column(name = "idRiesgos", nullable = false)
    private Integer id;

    @Column(name = "descripcion", nullable = false, length = 12)
    private String descripcion;

}