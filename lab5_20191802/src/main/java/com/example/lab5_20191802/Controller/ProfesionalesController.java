package com.example.lab5_20191802.Controller;

import com.example.lab5_20191802.Entity.Areas;
import com.example.lab5_20191802.Entity.Profesionales;
import com.example.lab5_20191802.Entity.Sedes;
import com.example.lab5_20191802.Repository.AreasRepository;
import com.example.lab5_20191802.Repository.DisponibilidadRepository;
import com.example.lab5_20191802.Repository.ProfesionalesRepository;
import com.example.lab5_20191802.Repository.SedesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/Profesional")
public class ProfesionalesController {

    @Autowired
    private ProfesionalesRepository profesionalesRepository;
    @Autowired
    private SedesRepository sedesRepository;
    @Autowired
    private AreasRepository areasRepository;
    @Autowired
    private DisponibilidadRepository disponibilidadRepository;

    @GetMapping("/Principal")
    public String principal(Model model,
                            @RequestParam(required = false) String sede,
                            @RequestParam(required = false) String area) {
        List<Profesionales> profesionales;

        // Intentar buscar los objetos por nombre si están presentes
        Sedes sedesObj = (sede != null && !sede.isEmpty()) ? sedesRepository.findByNombreSede(sede) : null;
        Areas areasObj = (area != null && !area.isEmpty()) ? areasRepository.findByNombreArea(area) : null;

        // Buscar los profesionales según los filtros aplicados
        if (sedesObj != null || areasObj != null) {
            profesionales = profesionalesRepository.findByFilters(sedesObj, areasObj);
        } else {
            // Si no hay filtros, mostrar todos los profesionales
            profesionales = profesionalesRepository.findAll();
        }

        // Pasar las listas de todas las sedes y áreas al modelo para el formulario de filtros
        model.addAttribute("todasLasSedes", sedesRepository.findAll());
        model.addAttribute("todasLasAreas", areasRepository.findAll());

        // Pasar los valores seleccionados de los filtros al modelo para que se mantengan en la vista
        model.addAttribute("sedeSeleccionada", sede);
        model.addAttribute("areaSeleccionada", area);

        model.addAttribute("profesionales", profesionales);
        return "Profesional/index";
    }
}