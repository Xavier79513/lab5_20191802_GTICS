package com.example.lab5_20191802.Repository;

import com.example.lab5_20191802.Entity.Riesgos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiesgosRepository extends JpaRepository<Riesgos, Integer> {
}
