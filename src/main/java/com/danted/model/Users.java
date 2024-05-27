package com.danted.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 15,nullable = false)
    private String username;

    @Column(length = 11)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(length = 10,nullable = false)
    private String datanascimento;
    
}
