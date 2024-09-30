package com.example.lab5_20191802.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Riesgos")
public class Riesgos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRiesgo", nullable = false)
    private Integer idRiesgo;

    @Column(name = "nivel", nullable = false, length = 50)
    private String nivel;

    @OneToMany(mappedBy = "riesgo",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private Set<Citas> citas = new LinkedHashSet<>();
}
