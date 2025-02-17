package com.example.gestione_viaggi.service;

import com.example.gestione_viaggi.entity.Dipendente;
import com.example.gestione_viaggi.entity.Prenotazione;
import com.example.gestione_viaggi.entity.Viaggio;
import com.example.gestione_viaggi.repository.DipendenteRepository;
import com.example.gestione_viaggi.repository.PrenotazioneRepository;
import com.example.gestione_viaggi.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PrenotazioneService {

    @Autowired
    private PrenotazioneRepository prenotazioneRepository;

    @Autowired
    private ViaggioRepository viaggioRepository;

    @Autowired
    private DipendenteRepository dipendenteRepository;

    public Prenotazione prenotaViaggio(Long dipendenteId, Long viaggioId, LocalDate dataRichiesta) {
        Dipendente dipendente = dipendenteRepository.findById(dipendenteId)
                .orElseThrow(() -> new IllegalArgumentException("Dipendente non trovato"));

        Viaggio viaggio = viaggioRepository.findById(viaggioId)
                .orElseThrow(() -> new IllegalArgumentException("Viaggio non trovato"));

        if (prenotazioneRepository.findByDipendenteAndDataRequest(dipendente, dataRichiesta).isPresent()) {
            throw new IllegalArgumentException("Il dipendente ha già una prenotazione per questa data");
        }

        // Crea una nuova prenotazione
        Prenotazione prenotazione = new Prenotazione();
        prenotazione.setDipendente(dipendente);
        prenotazione.setViaggio(viaggio);
        prenotazione.setDataRequest(dataRichiesta);

        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> getAllPrenotazioni() {
        return List.of();
    }

    public Prenotazione getPrenotazioneById(Long id) {
        return null;
    }
}
