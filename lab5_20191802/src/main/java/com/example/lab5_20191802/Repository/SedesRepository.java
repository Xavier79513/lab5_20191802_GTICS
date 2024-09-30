package com.example.lab5_20191802.Repository;


import com.example.lab5_20191802.Entity.Sedes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedesRepository extends JpaRepository<Sedes, Integer> {
    Sedes findByNombreSede(String nombreSede);
}