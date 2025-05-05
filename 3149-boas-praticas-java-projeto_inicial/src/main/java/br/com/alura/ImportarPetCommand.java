package br.com.alura;

import br.com.alura.client.ClientHttpConfiguration;
import br.com.alura.service.PetService;

import java.io.IOException;

public class ImportarPetCommand implements Command {

    @Override
    public void execute() {
        try {
            ClientHttpConfiguration clientHttpConfiguration = new ClientHttpConfiguration();
            PetService petService = new PetService(clientHttpConfiguration);
            petService.importarPetsDoAbrigo();
        } catch (IOException | InterruptedException e) {
            System.out.println("erro ao importar pets: " + e.getMessage());
        }
    }
}
