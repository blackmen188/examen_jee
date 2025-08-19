package com.example.demo.controller;

import com.example.demo.repository.ClasseRepository;
import com.example.demo.repository.SecteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private SecteurRepository sectorRepository;

    @GetMapping("/")
    public String home(Model model) {
        long totalClasses = classeRepository.count();
        long totalSecteurs = sectorRepository.count();

        model.addAttribute("totalClasses", totalClasses);
        model.addAttribute("totalSecteurs", totalSecteurs);

        return "index";
    }
}
