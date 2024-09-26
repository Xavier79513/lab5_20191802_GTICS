package com.example.lab5.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Profesional")
public class ProfessionalController {
    @GetMapping("/principal")
    public String viewprof(){return "/Professional/index";}

}
