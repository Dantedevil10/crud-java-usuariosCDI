package com.danted.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danted.model.Users;
import com.danted.repository.UsersRepository;

@Service
public class UserService {

    @Autowired
    private UsersRepository repository;

    public Users criarUsuario(Users user){
        return repository.save(user);
    }
    public List<Users> buscarTodos(){
        return repository.findAll();
    }
    public Users buscarPorId(Long id){
        return repository.findById(id).orElse(null);
    }
    public void deletarUsuario(Long id){
        repository.deleteById(id);
        return ;
    }

}
