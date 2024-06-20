package br.com.alura.fipefacil;

import br.com.alura.fipefacil.principal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FipeFacilApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(FipeFacilApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.exibirMenu();
    }
}
