package br.com.alura.fipefacil.service;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class ConverteDados implements IConverteDados{

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T converteDados(String caminho, Class<T> classeRetorno) {
        String json = ConsumoApi.obterDados(caminho);
        try {
            return mapper.readValue(json, classeRetorno);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
