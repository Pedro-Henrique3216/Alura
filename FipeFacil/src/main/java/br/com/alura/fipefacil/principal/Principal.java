package br.com.alura.fipefacil.principal;

import br.com.alura.fipefacil.model.*;
import br.com.alura.fipefacil.service.ConverteDados;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {

    private final String ENDERECO = "https://parallelum.com.br/fipe/api/v1/";
    private ConverteDados converteDados = new ConverteDados();
    private Scanner sc = new Scanner(System.in);

    public void exibirMenu(){
        System.out.println("Ola somos a FIPE facil onde você podera encontrar os preços do seu veiculo na tabela FIPE de forma facil e segura");
        System.out.println("Opções\n");
        System.out.println("CARROS\nMOTOS\nCAMINHOES\n");
        System.out.println("Primeiro digite que tipo de veiculo gostaria de procurar: ");
        String tipoDeVeiculo = sc.next();
        String endereco = ENDERECO;
        if(tipoDeVeiculo.toUpperCase().contains("CAR")){
            endereco += "CARROS";
        } else if(tipoDeVeiculo.toUpperCase().contains("MO")){
            endereco += "MOTOS";
        } else if(tipoDeVeiculo.toUpperCase().contains("CAM")){
            endereco += "CAMINHOES";
        }
        endereco += "/marcas";
        endereco = endereco.toLowerCase();
        List<Dados> marcas = Arrays.stream(converteDados.converteDados(endereco, Dados[].class))
               .collect(Collectors.toList());

        marcas.forEach(System.out::println);

        String codigoMarca;
        while(true){
            System.out.println("\nEscolha a marca pelo codigo da marca");
            codigoMarca = sc.next();
            String finalCodigoMarca = codigoMarca;
            Dados marca = marcas.stream()
                    .filter(m -> m.codigo().equals(finalCodigoMarca))
                    .findFirst()
                    .orElseThrow();

            System.out.println("\nVocê escolheu o carro da marca: " + marca.nome());
            System.out.println("\nEssa escolha esta certa? (S/N)");
            String escolhaCarro = sc.next();
            System.out.println();

            if(escolhaCarro.toUpperCase().contains("S")){
                break;
            }
        }

        endereco += "/" + codigoMarca + "/modelos";

        Modelos json = converteDados.converteDados(endereco, Modelos.class);

        List<Dados> modelos = json.modelos();
        modelos.forEach(System.out::println);

        System.out.println("\nDigite o nome do modelo que você ira querer: ");
        sc.nextLine();
        String nomeModelo = sc.nextLine();

        modelos.stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeModelo.toLowerCase()))
                .forEach(System.out::println);

        System.out.println("\nEscolha o modelo do carro pelo codigo: ");
        int codigoCarro = sc.nextInt();

        endereco += "/" + codigoCarro + "/anos";
        List<Dados> dados = converteDados.obterLista(endereco, Dados.class);

        List<Automovel> automoveis = new ArrayList<>();
        endereco += "/";
        for(Dados dado : dados){
            automoveis.add(converteDados.converteDados(endereco + dado.codigo(), Automovel.class));
        }

        automoveis.forEach(System.out::println);
    }
}
