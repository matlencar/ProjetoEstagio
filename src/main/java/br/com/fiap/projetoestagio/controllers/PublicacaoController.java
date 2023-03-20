package br.com.fiap.projetoestagio.controllers;

import java.time.LocalDate;
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

import br.com.fiap.projetoestagio.models.Publicacao;

@RestController
public class PublicacaoController {

    List<Publicacao> publi = new ArrayList<>();

    Logger log = LoggerFactory.getLogger(PublicacaoController.class);

    @GetMapping("/localhost/publicacao")
    @ResponseBody
    public Publicacao show() {

        Publicacao publicacao = new Publicacao((long)1, new String("Essa sera minnha primeira publicacao na plataforma, espero contrubuir muito com a comunidade dev"), LocalDate.now(), "Programando em java");

        return publicacao;
    }

    @PostMapping("/localhost/publicacao")
    public ResponseEntity<Publicacao> create(@RequestBody Publicacao publicacao){
      log.info("cadastrando a publicacao" + publicacao);
      publicacao.setId((long) 1);
        publi.add(publicacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(publicacao);
    }

    @GetMapping("/localhost/publicacao{id}")
    public ResponseEntity<Publicacao> show(@PathVariable Long id){
        log.info("buscando publicacoes com id: " + id);
        var publicacoesPostadas = publi.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(publicacoesPostadas.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(publicacoesPostadas.get());
    }

    @DeleteMapping("/localhost/publicacao{id}")
    public ResponseEntity<Publicacao> destroy(@PathVariable Long id){
        log.info("buscando publicacoes com id: " + id);
        var publicacoesPostadas = publi.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(publicacoesPostadas.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        publi.remove(publicacoesPostadas.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/localhost/publicacao{id}")
    public ResponseEntity<Publicacao> update(@PathVariable Long id, @RequestBody Publicacao publicacao){
        log.info("buscando publicacoes com id: " + id);
        var publicacoesPostadas = publi.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(publicacoesPostadas.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(publicacoesPostadas.get());
    }

}