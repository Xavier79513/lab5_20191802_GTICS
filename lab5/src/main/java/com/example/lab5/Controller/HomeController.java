package com.example.lab5.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/sistema")
public class HomeController {
    @GetMapping("/pagina")
    public String viewloguin(){return "/Sistema/index";}
}
