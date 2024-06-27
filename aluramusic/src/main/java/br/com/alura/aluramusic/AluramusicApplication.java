package br.com.alura.aluramusic;

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

    }
}
