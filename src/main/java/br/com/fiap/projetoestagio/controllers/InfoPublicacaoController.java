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

import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.exception.RestNotFoundException;

import br.com.fiap.projetoestagio.models.InfoPublicacao;
import br.com.fiap.projetoestagio.repository.InfoPublicacaoRepository;
import jakarta.validation.Valid;

@RestController
public class InfoPublicacaoController {

    @Autowired
    InfoPublicacaoRepository repository; //Injeção de dependencia
    
    Logger log = LoggerFactory.getLogger(InfoPublicacaoController.class);

    List<InfoPublicacao> info = new ArrayList<>();


     @GetMapping("/api/info")
    public List<InfoPublicacao> index() {
        return repository.findAll();
    }


    @PostMapping("/api/info")
    public ResponseEntity<InfoPublicacao> create(@RequestBody @Valid InfoPublicacao info) {
        log.info("informacoes complementares feitas com sucesso" + info);
       

        repository.save(info);

        return ResponseEntity.status(HttpStatus.CREATED).body(info);
    }

    @GetMapping("/api/info/{id}")
    public ResponseEntity<InfoPublicacao> show(@PathVariable int id){
        log.info("buscando as informacoes com o id: " + id);
        var infoPublicacao = getInfoPublicacao(id);

        return ResponseEntity.ok(infoPublicacao);
    }

    @DeleteMapping("/api/info/{id}")
    public ResponseEntity<InfoPublicacao> deleteId(@PathVariable int id){
        log.info("deletando informacoes complementares com o id: " + id);
        var infoPublicacao = getInfoPublicacao(id);

        info.remove(infoPublicacao);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/info/{id}")
    public ResponseEntity<InfoPublicacao> update(@PathVariable int id, @RequestBody @Valid InfoPublicacao infoPublicacao){
        log.info("atualizando o id: " + id);
        getInfoPublicacao(id);


        infoPublicacao.setId(id);
        repository.save(infoPublicacao);

        return ResponseEntity.ok(infoPublicacao);
    }

    private InfoPublicacao getInfoPublicacao(int id) {
        return repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Não a informações de cadastro encontradas no sistema"));
    }

}
