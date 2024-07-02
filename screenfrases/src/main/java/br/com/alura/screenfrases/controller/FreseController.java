package br.com.alura.screenfrases.controller;

import br.com.alura.screenfrases.dto.FraseDTO;
import br.com.alura.screenfrases.service.FraseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/series/frases")
public class FreseController {

    @Autowired
    private FraseService service;

    @GetMapping
    public ResponseEntity<FraseDTO> buscarFraseAleatoria() {
        return ResponseEntity.ok(service.fraseAleatoria());
    }

}
