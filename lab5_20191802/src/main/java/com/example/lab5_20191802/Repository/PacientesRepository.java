package com.example.lab5_20191802.Repository;

import com.example.lab5_20191802.Entity.Pacientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacientesRepository extends JpaRepository<Pacientes, Integer> {
    Pacientes findByDni(String dni);
}