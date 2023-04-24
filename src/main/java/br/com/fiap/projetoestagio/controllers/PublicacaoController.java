package br.com.fiap.projetoestagio.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    // List<Publicacao> publi = new ArrayList<>();

    @Autowired
    PublicacaoRepository repository; //Injeção de dependencia

    @Autowired
    PagedResourcesAssembler<Object> assembler;

    @GetMapping
    public PagedModel<EntityModel<Object>> index(@RequestParam(required = false) String publicacao, @PageableDefault(size = 3) Pageable pageable) {
        Page<Publicacao> publicacoes = (publicacao == null)?
        repository.findAll(pageable):
        repository.findByPublicacaoContaining(publicacao, pageable);
    
        return assembler.toModel(publicacoes.map(Publicacao::toEntityModel));
    }
    
    @PostMapping("/api/publicacao")
    public ResponseEntity<EntityModel<Publicacao>> create(@RequestBody @Valid Publicacao publicacao){
    log.info("cadastrando a publicacao" + publicacao);
      
      repository.save(publicacao);

        return ResponseEntity.created(publicacao.toEntityModel().getRequiredLink("self").toUri()).body(publicacao.toEntityModel());
    }

    @GetMapping("{id}")
    public EntityModel<Publicacao> show(@PathVariable Long id){
        log.info("buscando publicacoes com id: " + id);
        return getPublicacao(id).toEntityModel();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Publicacao> destroy(@PathVariable Long id){
        log.info("buscando publicacoes com id: " + id);
        var publicacao = getPublicacao(id);

        repository.delete(publicacao);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public EntityModel<Publicacao> update(@PathVariable Long id, @RequestBody @Valid Publicacao publicacao){
        log.info("buscando publicacoes com id: " + id);
        getPublicacao(id);
    
        publicacao.setId(id);
        repository.save(publicacao);

        return publicacao.toEntityModel();
    }

    private Publicacao getPublicacao(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Nenhuma publicacao encontrada no sistema"));
    }

}