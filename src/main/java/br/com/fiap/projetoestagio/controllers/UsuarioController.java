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
import br.com.fiap.projetoestagio.models.Usuario;
import br.com.fiap.projetoestagio.repository.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    List<Usuario> usuarios = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioRepository repository; //Injeção de dependencia

    @GetMapping
    public List<Usuario> index() {
        return repository.findAll();
    }
    
    @GetMapping()
    @ResponseBody
    public Usuario showUsuario() {

        Usuario user = new Usuario((long)1, "Matheus", 28, "Ola me chamo matheus e quero ser um desenvolvedor frontend", "Masculino","185784212" , "848578457", null);

        return user;
    }

    @PostMapping()
    public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario) {
        log.info("usuario cadastrados" + usuarios);
       
        repository.save(usuario);

        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Usuario> show(@PathVariable Long id){
        log.info("buscando publicacoes com id: " + id);
        var usuario = getUsuario(id);

        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Usuario> destroy(@PathVariable Long id){
        log.info("deletando usuarios com o id: " + id);
        var usuario = getUsuario(id);


        usuarios.remove(usuario);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody @Valid Usuario usuario){
        log.info("atualizando o id do login: " + id);
       getUsuario(id);

        usuario.setId(id);
        repository.save(usuario);

        return ResponseEntity.ok(usuario);
    }

    private Usuario getUsuario(Long id) {
        return repository.findById(id)
        .orElseThrow(() -> new RestNotFoundException("Nenhum usuario encontrada no sistema"));
    }

}
