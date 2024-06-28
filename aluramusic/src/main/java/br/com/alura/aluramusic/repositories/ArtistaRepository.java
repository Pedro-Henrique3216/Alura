package br.com.alura.aluramusic.repositories;

import br.com.alura.aluramusic.models.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    @Query("select a from Artista a where a.nome ilike %:nome%")
    Optional<Artista> buscarPorNome(String nome);
}
