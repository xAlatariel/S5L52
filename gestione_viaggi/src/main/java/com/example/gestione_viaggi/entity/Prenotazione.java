package com.example.gestione_viaggi.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "prenotazione")
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dipendente_id", nullable = false)
    private Dipendente dipendente;

    @ManyToOne
    @JoinColumn(name = "viaggio_id", nullable = false)
    private Viaggio viaggio;

    @Column(nullable = false)
    private LocalDate dataRequest;


}
