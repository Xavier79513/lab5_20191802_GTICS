package com.example.lab5_20191802.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Areas")
public class Areas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idArea")
    private Integer idArea;

    @Column(name = "nombreArea", nullable = false, length = 50)
    private String nombreArea;

    @OneToMany(mappedBy = "area",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Profesionales> profesionales = new LinkedHashSet<>();
}