package com.example.lab5_20191802.Controller;

import com.example.lab5_20191802.Entity.Profesionales;
import com.example.lab5_20191802.Repository.ProfesionalesRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/Profesional")
public class ProfesionalesController {
    final ProfesionalesRepository profesionalesRepository;
    

    public ProfesionalesController(ProfesionalesRepository profesionalesRepository) {
        this.profesionalesRepository = profesionalesRepository;
    }

    @GetMapping("/Principal")
    public String principal(Model model){
        List<Profesionales> listarProfesionales = profesionalesRepository.findAll();
        model.addAttribute("listarProfesionales", listarProfesionales);
        return "Profesional/index";
    }

}
