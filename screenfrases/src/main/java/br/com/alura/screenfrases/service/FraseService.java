package br.com.alura.screenfrases.service;

import br.com.alura.screenfrases.dto.FraseDTO;
import br.com.alura.screenfrases.model.Frase;
import br.com.alura.screenfrases.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {

    @Autowired
    private FraseRepository repository;

    public FraseDTO fraseAleatoria(){
        return converteDados(repository.retornaFraseAletoria());
    }

    private FraseDTO converteDados(Frase frase){
        return new FraseDTO(frase.getId(), frase.getTitulo(), frase.getFrase(), frase.getPoster(), frase.getPersonagem());
    }
}
