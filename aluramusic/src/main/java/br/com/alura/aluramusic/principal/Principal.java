package br.com.alura.aluramusic.principal;

import java.util.Scanner;

public class Principal {

    private Scanner sc = new Scanner(System.in);

    public void menu(){
        System.out.println("""
                1 - Cadastrar um Artista
                2 - Cadastrar um Musica
                3 - Listar Musicas
                4 - Buscar Musica por Artista""");
    }
}
