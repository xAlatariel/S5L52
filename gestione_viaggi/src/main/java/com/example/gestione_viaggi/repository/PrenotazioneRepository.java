package com.example.gestione_viaggi.repository;

import com.example.gestione_viaggi.entity.Dipendente;
import com.example.gestione_viaggi.entity.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {

    Optional<Prenotazione> findByDipendenteAndDataRequest(Dipendente dipendente, LocalDate dataRequest);
}