package br.com.alura.aluramusic.repositories;

import br.com.alura.aluramusic.models.Artista;
import br.com.alura.aluramusic.models.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistaRepository extends JpaRepository<Artista, Long> {

    @Query("select a from Artista a where a.nome ilike %:nome%")
    Optional<Artista> buscarPorNome(String nome);

    @Query("select m from Artista a JOIN a.musicas m")
    List<Musica> listarMusicas();

    @Query("select m from Artista a join a.musicas m where a = :artista")
    List<Musica> listarMusicasPorArtista(Artista artista);
}
