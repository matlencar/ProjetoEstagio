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

import br.com.fiap.projetoestagio.models.Usuario;

@RestController
public class UsuarioController {

    List<Usuario> usuarios = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(UsuarioController.class);
    
    @GetMapping("/localhost/usuario")
    @ResponseBody
    public Usuario showUsuario() {

        Usuario user = new Usuario((long)1, "Matheus", 28, "Ola me chamo matheus e quero ser um desenvolvedor frontend", "Masculino","185784212" , "848578457", null);

        return user;
    }

    @PostMapping("/localhost/usuario")
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario) {
        log.info("usuario cadastrados" + usuarios);
        usuarios.add(usuario);
        usuario.setId((long)1);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @GetMapping("/localhost/usuario{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        log.info("buscando usuarios cadastrados com o id: " + id);
        var usuariosCadastrados = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();
        if(usuariosCadastrados.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(usuariosCadastrados.get());
    }

    @DeleteMapping("/localhost/usuario{id}")
    public ResponseEntity<Usuario> destroy(@PathVariable Long id){
        log.info("deletando usuarios com o id: " + id);
        var usuariosCadastrados = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(usuariosCadastrados.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        usuarios.remove(usuariosCadastrados.get());

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/localhost/usuario{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario){
        log.info("atualizando o id do login: " + id);
        var usuariosCadastrados = usuarios.stream().filter(d -> d.getId().equals(id)).findFirst();

        if(usuariosCadastrados.isEmpty())
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        return ResponseEntity.ok(usuariosCadastrados.get());
    }
}
