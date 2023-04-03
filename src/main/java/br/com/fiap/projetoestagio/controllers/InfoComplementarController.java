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

import br.com.fiap.projetoestagio.config.RestNotFoundException;
import br.com.fiap.projetoestagio.models.InfoComplementar;
import br.com.fiap.projetoestagio.repository.InfoComplementarRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/complementares")
public class InfoComplementarController {

    List<InfoComplementar> info = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(InfoComplementarController.class);

    @Autowired
    InfoComplementarRepository repository;

    @GetMapping
    public List<InfoComplementar> index() {
        return repository.findAll();
    }
    
    @GetMapping()
    @ResponseBody
    public InfoComplementar showPerfilUser() {
        
        InfoComplementar complemento = new InfoComplementar((long)1, "Java", 2, "Ingles", 1);

        return complemento;
    }

    @PostMapping()
    public ResponseEntity<InfoComplementar> create(@RequestBody @Valid InfoComplementar informacoes) {
        log.info("informacoes complementares cadastradas com sucesso" + informacoes);
        
        repository.save(informacoes);

        return ResponseEntity.status(HttpStatus.CREATED).body(informacoes);
    }

    @GetMapping("{id}")
    public ResponseEntity<InfoComplementar> show(@PathVariable Long id){
        log.info("buscando as informacoes complementares com o id: " + id);
        var informacao =  getInformacComplementar(id);

        return ResponseEntity.ok(informacao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<InfoComplementar> deleteId(@PathVariable Long id){
        log.info("deletando informacoes complementares com o id: " + id);
        var informacao =  getInformacComplementar(id);


        info.remove(informacao);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<InfoComplementar> update(@PathVariable Long id, @RequestBody InfoComplementar informacoes){
        log.info("atualizando o id do das informacoes complementares: " + id);
        getInformacComplementar(id);

        informacoes.setId(id);
        repository.save(informacoes);

        return ResponseEntity.ok(informacoes);
    }

    private InfoComplementar getInformacComplementar(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Não a informações complementares encontradas no sistema"));
    }
}
