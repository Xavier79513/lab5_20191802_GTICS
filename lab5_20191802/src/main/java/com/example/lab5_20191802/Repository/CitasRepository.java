package com.example.lab5_20191802.Repository;

import com.example.lab5_20191802.DTO.CitasDTO;
import com.example.lab5_20191802.Entity.Citas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitasRepository extends JpaRepository<Citas, Integer> {

    @Query("SELECT c FROM Citas c WHERE " +
            "(:profesionalId IS NULL OR c.profesional.idProfesional = :profesionalId) AND " +
            "(:areaId IS NULL OR c.profesional.area.idArea = :areaId) AND " +
            "(:sedeId IS NULL OR c.profesional.sede.idsede = :sedeId) AND " +
            "(:riesgoId IS NULL OR c.riesgo.idRiesgo = :riesgoId) AND " +
            "(:fecha IS NULL OR c.disponibilidad.fecha = :fecha)")
    List<Citas> findCitasByFiltros(
            @RequestParam(required = false) Integer profesionalId,
            @RequestParam(required = false) Integer areaId,
            @RequestParam(required = false) Integer sedeId,
            @RequestParam(required = false) Integer riesgoId,
            @RequestParam(required = false) LocalDate fecha);


    @Query("SELECT new com.example.lab5_20191802.DTO.CitasDTO(c.profesional.sede.nombreSede, null, null, COUNT(c)) " +
            "FROM Citas c GROUP BY c.profesional.sede.nombreSede")
    List<CitasDTO> contarCitasPorSede();

    @Query("SELECT new com.example.lab5_20191802.DTO.CitasDTO(null, c.profesional.area.nombreArea, null, COUNT(c)) " +
            "FROM Citas c GROUP BY c.profesional.area.nombreArea")
    List<CitasDTO> contarCitasPorArea();

    @Query("SELECT new com.example.lab5_20191802.DTO.CitasDTO(null, null, c.profesional.nombre, COUNT(c)) " +
            "FROM Citas c GROUP BY c.profesional.nombre")
    List<CitasDTO> contarCitasPorProfesional();
}
