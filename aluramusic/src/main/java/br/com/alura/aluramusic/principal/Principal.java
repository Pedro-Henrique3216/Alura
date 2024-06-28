package br.com.alura.aluramusic.principal;

import br.com.alura.aluramusic.models.Artista;
import br.com.alura.aluramusic.repositories.ArtistaRepository;

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
}
