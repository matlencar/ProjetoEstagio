package br.com.fiap.projetoestagio.controllers;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.models.InfoComplementar;
import br.com.fiap.projetoestagio.repository.InfoComplementarRepository;

@RestController
@RequestMapping("/api/complementares")
public class InfoComplementarController {

    List<InfoComplementar> info = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(InfoComplementarController.class);

    @Autowired
    InfoComplementarRepository repository;
    
    @GetMapping()
    @ResponseBody
    public InfoComplementar showPerfilUser() {
        
        InfoComplementar complemento = new InfoComplementar((long)1, "Java", 2, "Ingles", 1);

        return complemento;
    }

    @PostMapping()
    public ResponseEntity<InfoComplementar> create(@RequestBody InfoComplementar informacoes) {
        log.info("informacoes complementares cadastradas com sucesso" + informacoes);
        
        repository.save(informacoes);

        return ResponseEntity.status(HttpStatus.CREATED).body(informacoes);
    }

    @GetMapping("{id}")
    public ResponseEntity<InfoComplementar> show(@PathVariable Long id){
        log.info("buscando as informacoes complementares com o id: " + id);
        var infoComplementares = repository.findById(id);

        if(infoComplementares.isEmpty())
        return ResponseEntity.notFound().build();

        return ResponseEntity.ok(infoComplementares.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<InfoComplementar> deleteId(@PathVariable Long id){
        log.info("deletando informacoes complementares com o id: " + id);
        var infoComplementares = repository.findById(id);

        if(infoComplementares.isEmpty())
        return ResponseEntity.notFound().build();

        info.remove(infoComplementares.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<InfoComplementar> update(@PathVariable Long id, @RequestBody InfoComplementar informacoes){
        log.info("atualizando o id do das informacoes complementares: " + id);
        var infoComplementares = repository.findById(id);

        if(infoComplementares.isEmpty())
        return ResponseEntity.notFound().build();

        informacoes.setId(id);
        repository.save(informacoes);

        return ResponseEntity.ok(infoComplementares.get());
    }
}
