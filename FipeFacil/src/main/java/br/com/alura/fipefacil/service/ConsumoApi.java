package br.com.alura.fipefacil.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

    public static String obterDados(String endereco) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 500) {
                throw new RuntimeException("Esse endereço não foi encontrado");
            }
        } catch (IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
        return response.body();
    }
}
