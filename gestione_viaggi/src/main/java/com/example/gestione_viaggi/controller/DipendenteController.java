package com.example.gestione_viaggi.controller;

import com.example.gestione_viaggi.entity.Dipendente;
import com.example.gestione_viaggi.service.DipendenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/dipendenti")
public class DipendenteController {

    @Autowired
    private DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> getAllDipendenti() {
        return dipendenteService.getAllDipendenti();
    }

    @GetMapping("/{id}")
    public Optional<Dipendente> getDipendenteById(@PathVariable Long id) {
        return dipendenteService.getDipendenteById(id);
    }

    @PostMapping
    public Dipendente createDipendente(@RequestBody Dipendente dipendente) {
        return dipendenteService.createDipendente(dipendente);
    }

    @PutMapping("/{id}")
    public Dipendente updateDipendente(@PathVariable Long id, @RequestBody Dipendente dipendenteDetails) {
        return dipendenteService.updateDipendente(id, dipendenteDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDipendente(@PathVariable Long id) {
        dipendenteService.deleteDipendente(id);
    }
}