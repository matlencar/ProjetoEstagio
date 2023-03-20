package br.com.fiap.projetoestagio.controllers;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.models.InfoComplementar;

@RestController
public class InfoComplementarController {

    List<InfoComplementar> info = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(InfoComplementarController.class);
    
    @GetMapping("/localhost/complementares")
    @ResponseBody
    public InfoComplementar showPerfilUser() {
        
        InfoComplementar complemento = new InfoComplementar((long) '1', "Java", 2, "Ingles", 1);

        return complemento;
    }

    @PostMapping("/localhost/complementaresv")
    public ResponseEntity<InfoComplementar> create(@RequestBody InfoComplementar informacoes) {
        log.info("informacoes complementares cadastradas com sucesso" + informacoes);
        info.add(informacoes);
        informacoes.setId((long) '1');
        return ResponseEntity.status(HttpStatus.CREATED).body(informacoes);
    }

    @GetMapping("/localhost/complementares{id}")
    public ResponseEntity<InfoComplementar> show(@PathVariable Long id){
        log.info("buscando as informacoes complementares com o id: " + id);
        var infoComplementares = info.stream().filter(d -> d.getId().equals(id)).findFirst();
        if(infoComplementares.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(infoComplementares.get());
    }

    @DeleteMapping("/localhost/complementares{id}")
    public ResponseEntity<InfoComplementar> deleteId(@PathVariable Long id){
        log.info("deletando informacoes complementares com o id: " + id);
        var infoComplementares = info.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(infoComplementares.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        info.remove(infoComplementares.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/localhost/complementares{id}")
    public ResponseEntity<InfoComplementar> update(@PathVariable Long id, @RequestBody InfoComplementar informacoes){
        log.info("atualizando o id do das informacoes complementares: " + id);
        var infoComplementares = info.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(infoComplementares.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(infoComplementares.get());
    }
}
