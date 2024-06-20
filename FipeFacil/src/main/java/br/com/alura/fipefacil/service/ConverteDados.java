package br.com.alura.fipefacil.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    @Override
    public <T> List<T> obterLista(String caminho, Class<T> classeRetorno) {
        String json = ConsumoApi.obterDados(caminho);
        try {
            CollectionType lista = mapper.getTypeFactory()
                    .constructCollectionType(List.class, classeRetorno);
            return mapper.readValue(json, lista);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

    }
}
