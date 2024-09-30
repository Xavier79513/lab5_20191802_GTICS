package com.example.lab5_20191802.Controller;

import com.example.lab5_20191802.Entity.Disponibilidad;
import com.example.lab5_20191802.Entity.Citas;
import com.example.lab5_20191802.Entity.Profesionales;
import com.example.lab5_20191802.Entity.Pacientes;
import com.example.lab5_20191802.Entity.Riesgos;
import com.example.lab5_20191802.Repository.PacientesRepository;
import com.example.lab5_20191802.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/Cita")
public class CitasController {

    @Autowired
    private ProfesionalesRepository profesionalesRepository;

    @Autowired
    private AreasRepository areasRepository;

    @Autowired
    private SedesRepository sedesRepository;

    @Autowired
    private CitasRepository citasRepository;

    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    @Autowired
    private PacientesRepository pacientesRepository;

    @Autowired
    private RiesgosRepository riesgosRepository;

    // Mostrar el formulario para agendar cita
    @GetMapping("/Nueva")
    public String nuevaCita(@RequestParam("profesionalId") Integer profesionalId, Model model) {
        Profesionales profesional = profesionalesRepository.findById(profesionalId).orElse(null);
        List<Disponibilidad> disponibilidad = disponibilidadRepository.findByProfesional_IdProfesionalAndDisponible(profesionalId, true);

        model.addAttribute("profesional", profesional);
        model.addAttribute("disponibilidad", disponibilidad);
        model.addAttribute("todasLasAreas", areasRepository.findAll());
        model.addAttribute("todasLasSedes", sedesRepository.findAll());
        return "Citas/nuevaCita";
    }

    // Guardar la cita en la base de datos
    @PostMapping("/Guardar")
    public String guardarCita(@RequestParam("profesionalId") Integer profesionalId,
                              @RequestParam("nombre") String nombre,
                              @RequestParam("dni") String dni,
                              @RequestParam("edad") Integer edad,
                              @RequestParam("motivoConsulta") String motivoConsulta,
                              @RequestParam("area") Integer areaId,
                              @RequestParam("sede") Integer sedeId,
                              @RequestParam("riesgoId") Integer riesgoId,
                              @RequestParam("disponibilidadId") Integer disponibilidadId,
                              @RequestParam("duracion") Integer duracion,
                              RedirectAttributes redirectAttributes) {

        // Buscar profesional, disponibilidad y riesgo
        Profesionales profesional = profesionalesRepository.findById(profesionalId).orElse(null);
        Disponibilidad disponibilidad = disponibilidadRepository.findById(disponibilidadId).orElse(null);
        Riesgos riesgo = riesgosRepository.findById(riesgoId).orElse(null);

        // Validar si el profesional, la disponibilidad, y la sede existen
        if (profesional == null || disponibilidad == null || riesgo == null) {
            redirectAttributes.addFlashAttribute("error", "Error en los datos proporcionados. Por favor, revise la información.");
            return "redirect:/Cita/Nueva?profesionalId=" + profesionalId;
        }

        // Validar si el profesional coincide con el área seleccionada
        if (!profesional.getArea().getIdArea().equals(areaId)) {
            redirectAttributes.addFlashAttribute("error", "El profesional no coincide con el área de especialidad seleccionada.");
            return "redirect:/Cita/Nueva?profesionalId=" + profesionalId;
        }

        // Validar si el profesional está disponible en la sede seleccionada
        if (!profesional.getSede().getIdsede().equals(sedeId)) {
            redirectAttributes.addFlashAttribute("error", "El profesional no está disponible en la sede seleccionada.");
            return "redirect:/Cita/Nueva?profesionalId=" + profesionalId;
        }

        // Validar si el profesional está disponible en la fecha seleccionada
        if (!disponibilidad.getDisponible() || !disponibilidad.getProfesional().getIdProfesional().equals(profesionalId)) {
            redirectAttributes.addFlashAttribute("error", "El profesional no está disponible en la fecha seleccionada.");
            return "redirect:/Cita/Nueva?profesionalId=" + profesionalId;
        }

        // Buscar o crear el paciente
        Pacientes paciente = pacientesRepository.findByDni(dni);
        if (paciente == null) {
            paciente = new Pacientes();
            paciente.setNombre(nombre);
            paciente.setDni(dni);
            paciente.setEdad(edad);
            pacientesRepository.save(paciente);
        }

        // Asignar precio según la duración seleccionada
        BigDecimal precio = duracion == 60 ? new BigDecimal("200") : new BigDecimal("150");

        // Crear nueva cita y guardar en la base de datos
        Citas cita = new Citas();
        cita.setMotivoConsulta(motivoConsulta);
        cita.setPaciente(paciente);
        cita.setPrecio(precio);
        cita.setDisponibilidad(disponibilidad);
        cita.setRiesgo(riesgo);
        cita.setProfesional(profesional);

        citasRepository.save(cita);

        // Mensaje de éxito
        redirectAttributes.addFlashAttribute("success", "La cita ha sido reservada exitosamente.");

        return "redirect:/Profesional/Principal";
    }
}