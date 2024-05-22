package com.danted.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.danted.model.Games;

@Repository
public interface GamesRepository extends JpaRepository<Games,Long>{
    
}
