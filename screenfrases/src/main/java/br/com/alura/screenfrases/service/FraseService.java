package br.com.alura.screenfrases.service;

import br.com.alura.screenfrases.dto.SerieDTO;
import br.com.alura.screenfrases.model.Frase;
import br.com.alura.screenfrases.repository.FraseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {

    @Autowired
    private FraseRepository repository;

    public SerieDTO fraseAleatoria(){
        return converteDados(repository.retornaFraseAletoria());
    }

    private SerieDTO converteDados(Frase frase){
        return new SerieDTO(frase.getId(), frase.getTitulo(), frase.getFrase(), frase.getPoster(), frase.getPersonagem());
    }
}
