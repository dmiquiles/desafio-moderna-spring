package com.desafio.desafio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.desafio.desafio.model.Cliente;
import com.desafio.desafio.repository.ClienteRepository;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
	}


	@Bean
	CommandLineRunner initDatabase(ClienteRepository clienteRepository) {
		return args -> {
			clienteRepository.deleteAll();

			Cliente c = new Cliente();
			c.setNome("Daniel");
			c.setDocumento("586061");
			c.setDataNascimento("08/09/1996");

			clienteRepository.save(c);
		};
	}

}
