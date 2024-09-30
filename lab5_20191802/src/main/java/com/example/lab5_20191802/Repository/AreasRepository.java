package com.example.lab5_20191802.Repository;

import com.example.lab5_20191802.Entity.Areas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AreasRepository extends JpaRepository<Areas, Integer> {
    Areas findByNombreArea(String nombreArea);
}