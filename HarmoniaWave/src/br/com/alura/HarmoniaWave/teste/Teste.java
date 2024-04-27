package br.com.alura.HarmoniaWave.teste;

import br.com.alura.HarmoniaWave.domain.MinhasPreferidas;
import br.com.alura.HarmoniaWave.domain.Musica;
import br.com.alura.HarmoniaWave.domain.Podcast;

public class Teste {

    public static void main(String[] args) {

        Musica minhaMusica = new Musica();
        minhaMusica.setTitulo("Minha ultima musica");
        minhaMusica.setCantor("MC Kevin");

        for (int i = 0; i < 1000; i++) {
            minhaMusica.reproduzir();
        }

        Podcast meuPodcast = new Podcast();
        meuPodcast.setTitulo("PodPah");
        meuPodcast.setHost("Igão");

        for (int i = 0; i < 5000; i++) {
            meuPodcast.curtir();
        }

        MinhasPreferidas minhasPreferidas = new MinhasPreferidas();
        minhasPreferidas.inclui(minhaMusica);
        minhasPreferidas.inclui(meuPodcast);
    }
}
