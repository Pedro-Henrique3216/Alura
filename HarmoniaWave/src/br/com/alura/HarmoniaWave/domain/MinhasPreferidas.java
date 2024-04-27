package br.com.alura.HarmoniaWave.domain;

public class MinhasPreferidas {

    public void inclui(Audio audio){
        if(audio.getClassificacao() >= 9){
            System.out.println(audio.getTitulo() + " é considerado sucesso absoluto");
        } else {
            System.out.println(audio.getTitulo() + " é um dos que todo mundo esta curtindo");
        }
    }
}
