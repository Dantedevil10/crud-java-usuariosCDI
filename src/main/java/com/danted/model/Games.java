package com.danted.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Games {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30,nullable = false)
    private String nomedojogo;

    @Column(length = 150)
    private String imagem;

    @Column(nullable = false)
    private String sumario;

    @Column(nullable = false)
    private String plataforma;

    @Column(nullable = false)
    private int anodelancamento;
    
}
