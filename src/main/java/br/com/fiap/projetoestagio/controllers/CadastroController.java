package br.com.fiap.projetoestagio.controllers;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

import br.com.fiap.projetoestagio.config.RestNotFoundException;
import br.com.fiap.projetoestagio.models.Cadastro;
import br.com.fiap.projetoestagio.repository.CadastroRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/cadastros")
public class CadastroController {


    @Autowired
    CadastroRepository repository; //Injeção de dependencia

    @GetMapping
    public List<Cadastro> index() {
        return repository.findAll();
    }

    List<Cadastro> cadastro = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(InfoComplementarController.class);


    // @GetMapping()
    // @ResponseBody
    // public Cadastro realizandoCadastro() {
    //     Cadastro cadastro = new Cadastro((long)1, "matheus@email.com", "matheusFiap20", "Matheus", new GregorianCalendar(1994, Calendar.AUGUST, 28), "s333222111");

    //     return cadastro;
    // }

    @PostMapping()
    public ResponseEntity<Cadastro> create(@RequestBody @Valid Cadastro cadastros) {
        log.info("informacoes complementares cadastradas com sucesso" + cadastros);
       

        repository.save(cadastros);

        return ResponseEntity.status(HttpStatus.CREATED).body(cadastros);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cadastro> show(@PathVariable Long id){
        log.info("buscando as informacoes do cadastro com o id: " + id);
        var cadastroUsuario = getCadastro(id);

        return ResponseEntity.ok(cadastroUsuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cadastro> deleteId(@PathVariable Long id){
        log.info("deletando informacoes complementares com o id: " + id);
        var cadastroUsuario = getCadastro(id);

        cadastro.remove(cadastroUsuario);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Cadastro> update(@PathVariable Long id, @RequestBody @Valid Cadastro cadastros){
        log.info("atualizando o id do cadastro: " + id);
        getCadastro(id);


        cadastros.setId(id);
        repository.save(cadastros);

        return ResponseEntity.ok(cadastros);
    }

    private Cadastro getCadastro(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Não a informações de cadastro encontradas no sistema"));
    }
}
