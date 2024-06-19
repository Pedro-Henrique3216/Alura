package br.com.alura.fipefacil.service;

public interface IConverteDados {

    <T> T converteDados(String restoCaminho, Class<T> classeRetorno);
}
