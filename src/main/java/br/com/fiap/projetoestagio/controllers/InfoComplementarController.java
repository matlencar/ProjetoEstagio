package br.com.fiap.projetoestagio.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.models.InfoComplementar;

@RestController
public class InfoComplementarController {
    
    @GetMapping("/api/complementares")
    @ResponseBody
    public InfoComplementar showPerfilUser() {
        
        InfoComplementar complemento = new InfoComplementar("Java", 2, "Ingles", 1);

        return complemento;
    }
}
