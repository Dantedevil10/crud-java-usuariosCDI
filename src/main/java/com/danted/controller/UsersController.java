package com.danted.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.danted.model.Users;
import com.danted.repository.UsersRepository;

import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    private final UsersRepository usersrepo;

    @GetMapping
    public List<Users> listaUsers(){
        return usersrepo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Users> findbyid(@PathVariable Long id){
        
        return usersrepo.findById(id)
        .map(recordFound -> ResponseEntity.ok().body(recordFound))
        .orElse(ResponseEntity.notFound().build());
    }
    
    @ResponseStatus(code= HttpStatus.CREATED)
    @PostMapping
    public Users criando(@RequestBody Users user){
       return usersrepo.save(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Users> update(@PathVariable Long id,@RequestBody Users user){
        return usersrepo.findById(id)
        .map(recordFound ->{
            recordFound.setUsername(user.getUsername());
            recordFound.setCpf(user.getCpf());
            recordFound.setEmail(user.getEmail());
            recordFound.setDatanascimento(user.getDatanascimento());
            Users updated = usersrepo.save(recordFound);
            return ResponseEntity.ok().body(updated);
        } )
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return usersrepo.findById(id)
        .map(recordFound ->{
            usersrepo.deleteById(id);
            return ResponseEntity.noContent().<Void>build();
        } )
        .orElse(ResponseEntity.notFound().build());
    }
}
