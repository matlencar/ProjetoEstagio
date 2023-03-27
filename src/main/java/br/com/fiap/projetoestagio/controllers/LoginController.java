package br.com.fiap.projetoestagio.controllers;

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

import br.com.fiap.projetoestagio.models.Login;

@RestController
public class LoginController {

    List<Login> users = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/localhost/login")
    @ResponseBody
    public Login showLogin() {

        Login login = new Login((long)1, "matheus@email.com", "10288ASw");

        return login;
    }

    @PostMapping("/api/login")
    public ResponseEntity<Login> create(@RequestBody Login login) {
        log.info("login efetuado" + login);
        login.setUsuario("10288ASw");
        login.setSenha("matheus@email.com");
        login.setId((long) 1);
        users.add(login);
        return ResponseEntity.status(HttpStatus.CREATED).body(login);
    }

    @GetMapping("/api/login{id}")
    public ResponseEntity<Login> show(@PathVariable Long id){
        log.info("buscando usuarios com o id: " + id);
        var usuariosLogados = users.stream().filter(d -> d.getId().equals(id)).findFirst();
        if(usuariosLogados.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(usuariosLogados.get());
    }

    @DeleteMapping("/api/login{id}")
    public ResponseEntity<Login> destroy(@PathVariable Long id){
        log.info("deletando usuarios com o id: " + id);
        var usuariosLogados = users.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(usuariosLogados.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        users.remove(usuariosLogados.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/api/login{id}")
    public ResponseEntity<Login> update(@PathVariable Long id, @RequestBody Login login){
        log.info("atualizando o id do login: " + id);
        var usuariosLogados = users.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(usuariosLogados.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(usuariosLogados.get());
    }
}
