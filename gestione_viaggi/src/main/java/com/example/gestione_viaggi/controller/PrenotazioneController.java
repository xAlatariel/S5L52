package com.example.gestione_viaggi.controller;

import com.example.gestione_viaggi.entity.Prenotazione;
import com.example.gestione_viaggi.service.PrenotazioneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prenotazioni")
public class PrenotazioneController {

    @Autowired
    private PrenotazioneService prenotazioneService;

    // Ottenere tutte le prenotazioni
    @GetMapping
    public List<Prenotazione> getAllPrenotazioni() {
        return prenotazioneService.getAllPrenotazioni();
    }

    // Ottenere una prenotazione tramite ID
    @GetMapping("/{id}")
    public Prenotazione getPrenotazioneById(@PathVariable Long id) {
        return prenotazioneService.getPrenotazioneById(id);
    }
}