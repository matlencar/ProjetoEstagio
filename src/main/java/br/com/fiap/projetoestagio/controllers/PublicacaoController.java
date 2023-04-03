package br.com.fiap.projetoestagio.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import br.com.fiap.projetoestagio.models.Publicacao;
import br.com.fiap.projetoestagio.repository.PublicacaoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/publicacao")
public class PublicacaoController {

    List<Publicacao> publi = new ArrayList<>();

    @Autowired
    PublicacaoRepository repository; //Injeção de dependencia

    Logger log = LoggerFactory.getLogger(PublicacaoController.class);

    @ResponseBody
    @GetMapping("/api/publicacao")
    public Publicacao show() {

        Publicacao publicacao = new Publicacao((long)1, new String("Essa sera minnha primeira publicacao na plataforma, espero contrubuir muito com a comunidade dev"), LocalDate.now(), "Programando em java");

        return publicacao;
    }

    @PostMapping("/api/publicacao")
    public ResponseEntity<Publicacao> create(@RequestBody @Valid Publicacao publicacao){
    //   if(result.hasErrors()) return ResponseEntity.badRequest().body(new RestValidationError("erro na validacao"));
    log.info("cadastrando a publicacao" + publicacao);
      
      repository.save(publicacao);

        return ResponseEntity.status(HttpStatus.CREATED).body(publicacao);
    }

    @GetMapping("{id}")
    public ResponseEntity<Publicacao> show(@PathVariable Long id){
        log.info("buscando publicacoes com id: " + id);
        var publicacao = getPublicacao(id);

        // if(publicacoesPostadas.isEmpty())
        // return ResponseEntity.notFound().build();

        return ResponseEntity.ok(publicacao);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Publicacao> destroy(@PathVariable Long id){
        log.info("buscando publicacoes com id: " + id);
        var publicacao = getPublicacao(id);

        // if(publicacoesPostadas.isEmpty())
        // return ResponseEntity.notFound().build();

        
        repository.delete(publicacao);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Publicacao> update(@PathVariable Long id, @RequestBody @Valid Publicacao publicacao){
        log.info("buscando publicacoes com id: " + id);
        // var publicacoesPostadas = repository.findById(id);
        getPublicacao(id);
        // if(publicacoesPostadas.isEmpty())
        // return ResponseEntity.notFound().build();

        publicacao.setId(id);
        repository.save(publicacao);

        return ResponseEntity.ok(publicacao);
    }

    private Publicacao getPublicacao(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Nenhuma publicacao encontrada no sistema"));
    }

}