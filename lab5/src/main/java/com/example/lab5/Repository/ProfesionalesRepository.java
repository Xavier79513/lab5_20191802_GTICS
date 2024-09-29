package com.example.lab5.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesionalesRepository extends JpaRepository<Profesionales, Integer> {

}
