package br.com.alura.fipefacil.service;

import java.util.List;

public interface IConverteDados {

    <T> T converteDados(String caminho, Class<T> classeRetorno);

    <T> List<T> obterLista(String caminho, Class<T> classeRetorno);
}
