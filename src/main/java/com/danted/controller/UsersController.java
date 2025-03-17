package com.danted.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.danted.service.UserService;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {

    @Autowired
    private UserService service;

    @GetMapping("/all")
    public ResponseEntity<List<Users>> buscarTodos(){
       return ResponseEntity.ok(service.buscarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Users> buscarUsuario(@PathVariable Long id){
       return ResponseEntity.ok(service.buscarPorId(id));
    }

    @PostMapping("/save")
    public ResponseEntity<Users> criarUsuario(@RequestBody Users user){
        return ResponseEntity.ok(service.criarUsuario(user));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deletarUsuario(@PathVariable Long id){
        service.deletarUsuario(id);
        return ResponseEntity.ok().body("Usuario Deletado Com Sucesso");
    }
}
