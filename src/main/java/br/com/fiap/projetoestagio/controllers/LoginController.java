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
import br.com.fiap.projetoestagio.models.Login;
import br.com.fiap.projetoestagio.repository.LoginRepository;
import jakarta.validation.Valid;

@RequestMapping("/api/login")
@RestController
public class LoginController {

    List<Login> users = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    LoginRepository repository; //Injeção de dependencia

    @GetMapping
    public List<Login> index() {
        return repository.findAll();
    }

    // @GetMapping("/localhost/login")
    // @ResponseBody
    // public Login showLogin() {

    //     Login login = new Login((long)1, "matheus@email.com", "10288ASw");

    //     return login;
    // }

    @PostMapping()
    public ResponseEntity<Login> create(@RequestBody @Valid Login login) {
        log.info("login efetuado" + login);
       
        repository.save(login);

        return ResponseEntity.status(HttpStatus.CREATED).body(login);
    }

    @GetMapping("{id}")
    public ResponseEntity<Login> show(@PathVariable Long id){
        log.info("buscando usuarios com o id: " + id);
        var login = getLogin(id);

        return ResponseEntity.ok(login);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Login> destroy(@PathVariable Long id){
        log.info("deletando usuarios com o id: " + id);
        var login = getLogin(id);

        users.remove(login);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Login> update(@PathVariable Long id, @RequestBody @Valid Login login){
        log.info("atualizando o id do login: " + id);
        getLogin(id);

        login.setId(id);
        repository.save(login);

        return ResponseEntity.ok(login);
    }

    private Login getLogin(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Nenhuma publicacao encontrada no sistema"));
    }
}
