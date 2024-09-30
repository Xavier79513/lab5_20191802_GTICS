package com.example.lab5_20191802.Repository;

import com.example.lab5_20191802.Entity.Disponibilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Integer> {
    List<Disponibilidad> findByProfesional_IdProfesionalAndDisponible(Integer profesionalId, boolean disponible);
}