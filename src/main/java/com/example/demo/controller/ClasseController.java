package com.example.demo.controller;

import com.example.demo.entity.Classe;
import com.example.demo.service.ClasseService;
import com.example.demo.service.SecteurService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/classes")
public class ClasseController {
    private final ClasseService classeService;
    private final SecteurService secteurService;

    public ClasseController(ClasseService classeService, SecteurService secteurService) {
        this.classeService = classeService;
        this.secteurService = secteurService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("classes", classeService.findAll());
        return "classe/list";
    }

    @GetMapping("/create")
    public String form(Model model) {
        model.addAttribute("classe", new Classe());
        model.addAttribute("secteurs", secteurService.findAll()); // 🔥 pour le dropdown
        return "classe/form";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Classe classe) {
        classeService.save(classe);
        return "redirect:/classes";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("classe", classeService.findById(id));
        model.addAttribute("secteurs", secteurService.findAll()); // 🔥 pour le dropdown
        return "classe/form";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        classeService.deleteById(id);
        return "redirect:/classes";
    }
}
