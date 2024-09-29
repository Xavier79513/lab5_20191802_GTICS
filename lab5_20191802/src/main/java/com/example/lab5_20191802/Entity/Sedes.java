package com.example.lab5_20191802.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Sedes")
public class Sedes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idSede")
    private Integer idsede;

    @Column(name = "nombreSede", nullable = false, length = 50)
    private String nombreSede;

    @OneToMany(mappedBy = "sede",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Profesionales> profesionales = new LinkedHashSet<>();

}
