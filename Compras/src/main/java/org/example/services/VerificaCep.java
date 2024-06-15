package org.example.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.domain.Endereco;
import org.example.domain.EnderecoDTO;
import org.example.exception.EnderecoNotFound;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class VerificaCep {

    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static Endereco retornaEndereco(String cep, String numero) throws IOException, InterruptedException {
        String endereco = "http://viacep.com.br/ws/" + cep + "/json/";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        if (response.statusCode() == 400) {
            throw new EnderecoNotFound("Endereço não encontrado.");
        }
        return gson.fromJson(response.body(), EnderecoDTO.class).toEndereco(numero);
    }
}

