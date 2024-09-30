package com.example.lab5_20191802.Repository;

import com.example.lab5_20191802.Entity.Areas;
import com.example.lab5_20191802.Entity.Profesionales;
import com.example.lab5_20191802.Entity.Sedes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfesionalesRepository extends JpaRepository<Profesionales, Integer> {
    @Query("SELECT p FROM Profesionales p WHERE " +
            "(:sedes IS NULL OR p.sede = :sedes) AND " +
            "(:areas IS NULL OR p.area = :areas)")
    List<Profesionales> findByFilters(@Param("sedes") Sedes sedes,
                                      @Param("areas") Areas areas);
}