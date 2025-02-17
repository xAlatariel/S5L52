package com.example.gestione_viaggi.repository;

import com.example.gestione_viaggi.entity.Dipendente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DipendenteRepository extends JpaRepository <Dipendente, Long> {
    Optional<Dipendente> findByUsername(String username);
}