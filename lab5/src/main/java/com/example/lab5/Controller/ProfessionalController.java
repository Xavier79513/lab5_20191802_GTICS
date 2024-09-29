package com.example.lab5.Controller;

import com.example.lab5.Repository.FechasRepository;
import com.example.lab5.Repository.ProfesionalesRepository;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/Profesional")
public class ProfessionalController {

    final ProfesionalesRepository professionalesRepository;
    final FechasRepository fechasRepository;

    public ProfessionalController(ProfesionalesRepository professionalesRepository, FechasRepository fechasRepository) {
        this.professionalesRepository = professionalesRepository;
        this.fechasRepository = fechasRepository;
    }

    @GetMapping("/principal")
    public String listProf(Model model){
        List<Profesionales> listaProfesionales = professionalesRepository.findAll();
        model.addAttribute("listaProfesionales", listaProfesionales);
        return "/Profesional/index";
    }
}