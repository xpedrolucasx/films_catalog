package br.com.films_catalog;

import br.com.films_catalog.Objetos.Filme;
import br.com.films_catalog.Repositorio.FilmeRepositorio;
import br.com.films_catalog.Servico.MenuFilmeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilmsCatalogApplication implements CommandLineRunner {
	private MenuFilmeService menu;

	public FilmsCatalogApplication(MenuFilmeService menu) {
		this.menu = menu;
	}

	public static void main(String[] args) {

		SpringApplication.run(FilmsCatalogApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		this.menu.menu();
	}
}
