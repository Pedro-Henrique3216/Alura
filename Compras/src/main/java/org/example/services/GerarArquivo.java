package org.example.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.example.domain.Endereco;

import java.io.FileWriter;
import java.io.IOException;

public class GerarArquivo {

    public static void geraArquivo(Endereco endereco) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fileWriter = new FileWriter(endereco.getCep() + ".json");
        fileWriter.write(gson.toJson(endereco));

        fileWriter.close();
    }
}
