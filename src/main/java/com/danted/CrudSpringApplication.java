package com.danted;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.danted.model.Users;
import com.danted.repository.UsersRepository;

@SpringBootApplication
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
	CommandLineRunner initDatabase(UsersRepository gamesrepository){
		return args -> {
			gamesrepository.deleteAll();

			Users u = new Users();
			u.setUsername("Carlin");
			u.setCpf("14365278911");
			u.setEmail("carlinpassaorodo2020@gmail.com");
			u.setDatanascimento("11/07/2000");

			gamesrepository.save(u);
		};
	}

}
