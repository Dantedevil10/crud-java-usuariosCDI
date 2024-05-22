package com.danted;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.danted.model.Games;
import com.danted.repository.GamesRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(GamesRepository gamesrepository){
		return args -> {
			gamesrepository.deleteAll();

			Games g = new Games();
			g.setNomedojogo("God Of War");
			g.setPlataforma("Ps2");
			g.setAnodelancamento(2005);
			g.setSumario("FODASE");

			gamesrepository.save(g);
		};
	}

}
