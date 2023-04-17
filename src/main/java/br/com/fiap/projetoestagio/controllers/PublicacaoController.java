package br.com.fiap.projetoestagio.controllers;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.config.RestNotFoundException;
import br.com.fiap.projetoestagio.models.Publicacao;
import br.com.fiap.projetoestagio.repository.PublicacaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/publicacao")
public class PublicacaoController {

    Logger log = LoggerFactory.getLogger(PublicacaoController.class);
    List<Publicacao> publi = new ArrayList<>();

    @Autowired
    PublicacaoRepository repository; //Injeção de dependencia

    @GetMapping
    public Page<Publicacao> index(@RequestParam(required = false) String publicacao, @PageableDefault(size = 3) Pageable pageable) {
        if(publicacao == null)
        return repository.findAll(pageable);
    
        return repository.findByPublicacaoContaining(publicacao, pageable);
    }
    
    @PostMapping("/api/publicacao")
    public ResponseEntity<Publicacao> create(@RequestBody @Valid Publicacao publicacao){
    log.info("cadastrando a publicacao" + publicacao);
      
      repository.save(publicacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(publicacao);
    }

    @GetMapping("{id}")
    public ResponseEntity<Publicacao> show(@PathVariable Long id){
        log.info("buscando publicacoes com id: " + id);
        var publicacao = getPublicacao(id);

        return ResponseEntity.ok(publicacao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Publicacao> destroy(@PathVariable Long id){
        log.info("buscando publicacoes com id: " + id);
        var publicacao = getPublicacao(id);

        repository.delete(publicacao);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Publicacao> update(@PathVariable Long id, @RequestBody @Valid Publicacao publicacao){
        log.info("buscando publicacoes com id: " + id);
        getPublicacao(id);
    
        publicacao.setId(id);
        repository.save(publicacao);

        return ResponseEntity.ok(publicacao);
    }

    private Publicacao getPublicacao(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Nenhuma publicacao encontrada no sistema"));
    }

}