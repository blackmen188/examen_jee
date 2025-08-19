package com.example.demo.service;

import com.example.demo.entity.Secteur;
import com.example.demo.repository.SecteurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurService {
    private final SecteurRepository repository;

    public SecteurService(SecteurRepository repository) {
        this.repository = repository;
    }

    public List<Secteur> findAll() {
        return repository.findAll();
    }

    public Secteur save(Secteur secteur) {
        return repository.save(secteur);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Secteur findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}