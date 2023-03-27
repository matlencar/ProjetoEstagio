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

import br.com.fiap.projetoestagio.models.Cadastro;
import br.com.fiap.projetoestagio.repository.CadastroRepository;

@RestController
@RequestMapping("/api/cadastros")
public class CadastroController {


    @Autowired
    CadastroRepository repository; //Injeção de dependencia

    List<Cadastro> cadastro = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(InfoComplementarController.class);


    
    @GetMapping()
    @ResponseBody
    public Cadastro realizandoCadastro() {
        Cadastro cadastro = new Cadastro((long)1, "matheus@email.com", "matheusFiap20", "Matheus", new GregorianCalendar(1994, Calendar.AUGUST, 28), "s333222111");

        return cadastro;
    }

    @PostMapping()
    public ResponseEntity<Cadastro> create(@RequestBody Cadastro cadastros) {
        log.info("informacoes complementares cadastradas com sucesso" + cadastros);
       

        repository.save(cadastros);

        return ResponseEntity.status(HttpStatus.CREATED).body(cadastros);
    }

    @GetMapping("{id}")
    public ResponseEntity<Cadastro> show(@PathVariable Long id){
        log.info("buscando as informacoes do cadastro com o id: " + id);
        var cadastroUsuario = repository.findById(id);

        if(cadastroUsuario.isEmpty())
        return ResponseEntity.notFound().build();

        return ResponseEntity.ok(cadastroUsuario.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Cadastro> deleteId(@PathVariable Long id){
        log.info("deletando informacoes complementares com o id: " + id);
        var cadastroUsuario = repository.findById(id);

        if(cadastroUsuario.isEmpty())
        return ResponseEntity.notFound().build();

        cadastro.remove(cadastroUsuario.get());

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Cadastro> update(@PathVariable Long id, @RequestBody Cadastro cadastros){
        log.info("atualizando o id do cadastro: " + id);
        var cadastroUsuario = repository.findById(id);

        if(cadastroUsuario.isEmpty())
        return ResponseEntity.notFound().build();

        cadastros.setId(id);
        repository.save(cadastros);

        return ResponseEntity.ok(cadastroUsuario.get());
    }
}
