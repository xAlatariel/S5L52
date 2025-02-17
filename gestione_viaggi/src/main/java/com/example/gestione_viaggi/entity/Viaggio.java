package com.example.gestione_viaggi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
@Entity
@Data
@Table(name = "viaggio")
public class Viaggio {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String destinazione;

    @Column(nullable = false)
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    public enum Stato {
        IN_CORSO, COMPLETATO
    }
}
