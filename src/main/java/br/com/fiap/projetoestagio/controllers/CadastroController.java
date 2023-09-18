package br.com.fiap.projetoestagio.controllers;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.projetoestagio.exception.RestNotFoundException;
import br.com.fiap.projetoestagio.models.Cadastro;
import br.com.fiap.projetoestagio.repository.CadastroRepository;
import jakarta.validation.Valid;

@RestController
// @RequestMapping("/api/cadastros")
public class CadastroController {


    @Autowired
    CadastroRepository repository; //Injeção de dependencia

    @GetMapping("/api/cadastros")
    public List<Cadastro> index() {
        return repository.findAll();
    }

    List<Cadastro> cadastro = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(CadastroController.class);

    @PostMapping("/api/cadastros")
    public ResponseEntity<Cadastro> create(@RequestBody @Valid Cadastro cadastros) {
        log.info("informacoes complementares cadastradas com sucesso" + cadastros);
       

        repository.save(cadastros);

        return ResponseEntity.status(HttpStatus.CREATED).body(cadastros);
    }

    @GetMapping("/api/cadastros/{id}")
    public ResponseEntity<Cadastro> show(@PathVariable int id){
        log.info("buscando as informacoes do cadastro com o id: " + id);
        var cadastroUsuario = getCadastro(id);

        return ResponseEntity.ok(cadastroUsuario);
    }

    @DeleteMapping("/api/cadastros/{id}")
    public ResponseEntity<Cadastro> deleteId(@PathVariable int id){
        log.info("deletando informacoes complementares com o id: " + id);
        var cadastroUsuario = getCadastro(id);

        cadastro.remove(cadastroUsuario);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/cadastros/{id}")
    public ResponseEntity<Cadastro> update(@PathVariable int id, @RequestBody @Valid Cadastro cadastros){
        log.info("atualizando o id do cadastro: " + id);
        getCadastro(id);


        cadastros.setId(id);
        repository.save(cadastros);

        return ResponseEntity.ok(cadastros);
    }

    private Cadastro getCadastro(int id) {
        return repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Não a informações de cadastro encontradas no sistema"));
    }
}
