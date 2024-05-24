package com.danted.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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

    @GetMapping("/{id}")
    public ResponseEntity<Games> findbyid(@PathVariable Long id){
        
        return gamesrepo.findById(id)
        .map(record -> ResponseEntity.ok().body(record))
        .orElse(ResponseEntity.notFound().build());
    }
    
    @ResponseStatus(code= HttpStatus.CREATED)
    @PostMapping
    public Games criando(@RequestBody Games games){

        //System.out.println(games.getNomedojogo());
       // return ResponseEntity.status(HttpStatus.CREATED).body(gamesrepo.save(games));
       return gamesrepo.save(games);
    }
}
