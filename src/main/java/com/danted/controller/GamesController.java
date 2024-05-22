package com.danted.controller;


import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danted.model.Games;
import com.danted.repository.GamesRepository;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/games")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class GamesController {

    private final GamesRepository gamesrepo;

    @GetMapping
    public List<Games> listaGames(){
        return gamesrepo.findAll();
    }
    
}
