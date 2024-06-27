package br.com.alura.aluramusic;

import br.com.alura.aluramusic.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AluramusicApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AluramusicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.menu();
    }
}
