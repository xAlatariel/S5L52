package com.example.gestione_viaggi.controller;

import com.example.gestione_viaggi.entity.Viaggio;
import com.example.gestione_viaggi.service.ViaggioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/viaggi")
public class ViaggioController {

    @Autowired
    private ViaggioService viaggioService;

    @GetMapping
    public List<Viaggio> getAllViaggi() {
        return viaggioService.getAllViaggi();
    }

    @GetMapping("/{id}")
    public Optional<Viaggio> getViaggioById(@PathVariable Long id) {
        return viaggioService.getViaggioById(id);
    }

    @PostMapping
    public Viaggio createViaggio(@RequestBody Viaggio viaggio) {
        return viaggioService.createViaggio(viaggio);
    }

    @PutMapping("/{id}")
    public Viaggio updateViaggio(@PathVariable Long id, @RequestBody Viaggio viaggioDetails) {
        return viaggioService.updateViaggio(id, viaggioDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteViaggio(@PathVariable Long id) {
        viaggioService.deleteViaggio(id);
    }
}