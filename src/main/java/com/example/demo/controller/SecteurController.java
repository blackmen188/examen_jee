package com.example.demo.controller;

import com.example.demo.entity.Secteur;
import com.example.demo.service.SecteurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/secteurs")
public class SecteurController {
    private final SecteurService service;

    public SecteurController(SecteurService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("secteurs", service.findAll());
        return "secteur/list";
    }

    @GetMapping("/create")
    public String form(Model model) {
        model.addAttribute("secteur", new Secteur());
        return "secteur/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Secteur secteur) {
        service.save(secteur);
        return "redirect:/secteurs";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("secteur", service.findById(id));
        return "secteur/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/secteurs";
    }
}