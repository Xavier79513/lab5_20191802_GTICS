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
@Table(name = "sedes")
public class Sede {
    @Id
    @Column(name = "idSedes", nullable = false)
    private Integer id;

    @Column(name = "nombreSede", nullable = false, length = 45)
    private String nombreSede;

}