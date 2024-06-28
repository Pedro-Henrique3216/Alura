package br.com.alura.aluramusic.repositories;

import br.com.alura.aluramusic.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
