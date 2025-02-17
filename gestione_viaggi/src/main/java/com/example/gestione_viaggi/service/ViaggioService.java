package com.example.gestione_viaggi.service;

import com.example.gestione_viaggi.entity.Viaggio;
import com.example.gestione_viaggi.repository.ViaggioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViaggioService {

    @Autowired
    private ViaggioRepository viaggioRepository;



    public List<Viaggio> getAllViaggi() {
        return viaggioRepository.findAll();
    }



    public Optional<Viaggio> getViaggioById(Long id) {
        return viaggioRepository.findById(id);
    }



    public Viaggio createViaggio(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }



    public Viaggio updateViaggio(Long id, Viaggio viaggioDetails) {
        Optional<Viaggio> viaggio = viaggioRepository.findById(id);
        if (viaggio.isPresent()) {
            viaggio.get().setDestinazione(viaggioDetails.getDestinazione());
            viaggio.get().setData(viaggioDetails.getData());
            viaggio.get().setStato(viaggioDetails.getStato());
            return viaggioRepository.save(viaggio.get());
        }
        return null;
    }



    public void deleteViaggio(Long id) {
        viaggioRepository.deleteById(id);
    }
}