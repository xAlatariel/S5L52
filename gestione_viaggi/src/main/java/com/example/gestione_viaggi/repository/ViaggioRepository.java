package com.example.gestione_viaggi.repository;

import com.example.gestione_viaggi.entity.Viaggio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViaggioRepository extends JpaRepository<Viaggio, Long> {
}