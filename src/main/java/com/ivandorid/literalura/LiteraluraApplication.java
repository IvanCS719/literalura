package com.ivandorid.literalura;

import com.ivandorid.literalura.main.Main;
import com.ivandorid.literalura.repository.IAutorRepository;
import com.ivandorid.literalura.repository.ILibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {
	@Autowired
	private IAutorRepository autorRepository;
	@Autowired
	private ILibroRepository libroRepository;
	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(autorRepository, libroRepository);
		main.ejecutarAplicacion();
	}
}
