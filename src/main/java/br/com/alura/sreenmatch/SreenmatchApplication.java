package br.com.alura.sreenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import br.com.alura.sreenmatch.principal.MenuPrincipal;

@SpringBootApplication
public class SreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		MenuPrincipal menuPrincipal = new MenuPrincipal();
		menuPrincipal.exibeMenu();
	}

}
