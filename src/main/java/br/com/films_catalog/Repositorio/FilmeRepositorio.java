package br.com.films_catalog.Repositorio;

import br.com.films_catalog.Objetos.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmeRepositorio extends JpaRepository<Filme, Integer> {
}
