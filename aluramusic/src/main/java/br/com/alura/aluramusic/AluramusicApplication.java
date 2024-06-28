package br.com.alura.aluramusic;

import br.com.alura.aluramusic.principal.Principal;
import br.com.alura.aluramusic.repositories.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluramusicApplication implements CommandLineRunner {

    @Autowired
    private ArtistaRepository artistaRepository;
    public static void main(String[] args) {
        SpringApplication.run(AluramusicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal(artistaRepository);
        principal.menu();
    }
}
