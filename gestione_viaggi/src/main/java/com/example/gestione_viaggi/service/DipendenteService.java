package com.example.gestione_viaggi.service;

import com.example.gestione_viaggi.entity.Dipendente;
import com.example.gestione_viaggi.repository.DipendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DipendenteService {

    @Autowired
    private DipendenteRepository dipendenteRepository;




    public List<Dipendente> getAllDipendenti() {
        return dipendenteRepository.findAll();
    }





    public Optional<Dipendente> getDipendenteById(Long id) {
        return dipendenteRepository.findById(id);
    }




    public Dipendente createDipendente(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    public Dipendente updateDipendente(Long id, Dipendente dipendenteDetails) {
        Optional<Dipendente> dipendente = dipendenteRepository.findById(id);
        if (dipendente.isPresent()) {
            dipendente.get().setUsername(dipendenteDetails.getUsername());
            dipendente.get().setNome(dipendenteDetails.getNome());
            dipendente.get().setCognome(dipendenteDetails.getCognome());
            dipendente.get().setEmail(dipendenteDetails.getEmail());
            return dipendenteRepository.save(dipendente.get());
        }
        return null;
    }




    public void deleteDipendente(Long id) {
        dipendenteRepository.deleteById(id);
    }
}