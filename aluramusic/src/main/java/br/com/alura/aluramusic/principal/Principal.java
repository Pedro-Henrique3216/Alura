package br.com.alura.aluramusic.principal;

import br.com.alura.aluramusic.models.Artista;
import br.com.alura.aluramusic.models.Musica;
import br.com.alura.aluramusic.repositories.ArtistaRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner(System.in);
    private ArtistaRepository repository;

    public Principal(ArtistaRepository repository) {
        this.repository = repository;
    }

    public void menu(){
        System.out.println("""
                1 - Cadastrar um Artista
                2 - Cadastrar um Musica
                3 - Listar Musicas
                4 - Buscar Musica por Artista""");

        System.out.println("Digite uma opção");
        int opcao = sc.nextInt();
        sc.nextLine();
        switch(opcao){
            case 1:
                cadastrarArtista();
                break;
            case 2:
                cadastrarMusica();
                break;
            case 3:
                listarMusica();
                break;
            default:
                System.out.println("Opção invalida");
                break;
        }
    }

    private void cadastrarArtista(){
        System.out.println("Digite o nome do artista: ");
        String nomeArtista = sc.nextLine();
        System.out.println("Digite o tipo do artista");
        String tipoArtista = sc.nextLine();
        Artista artista = new Artista(nomeArtista, tipoArtista);
       repository.save(artista);
    }

    private void listarArtista(){
        List<Artista> artistas = repository.findAll();
        artistas.forEach(System.out::println);
    }

    private void cadastrarMusica(){
        listarArtista();
        System.out.println("Digite o nome do artista: ");
        String nomeArtista = sc.nextLine();
        Optional<Artista> verificacao = repository.buscarPorNome(nomeArtista);
        if(verificacao.isPresent()){
            Artista artista = verificacao.get();
            System.out.println("Digite o nome da musica: ");
            String titulo = sc.nextLine();
            System.out.println("Digite a data de lançamento: ex.(12/12/2024)");
            String dataLancamento = sc.nextLine();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            Musica musica = new Musica(titulo, artista, LocalDate.parse(dataLancamento, dtf));
            artista.getMusicas().add(musica);
            repository.save(artista);
        } else {
            System.out.println("Artista não encontrado");
        }
    }

    private void listarMusica(){
        List<Musica> musicas = repository.listarMusicas();
        musicas.forEach(System.out::println);
    }
}
