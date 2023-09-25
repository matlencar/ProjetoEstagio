package br.com.fiap.projetoestagio.controllers;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.exception.RestNotFoundException;
import br.com.fiap.projetoestagio.models.Credencial;
import br.com.fiap.projetoestagio.models.Usuario;
import br.com.fiap.projetoestagio.repository.UsuarioRepository;
import br.com.fiap.projetoestagio.service.TokenService;
import jakarta.validation.Valid;

@RestController
// @RequestMapping("/api/usuarios")
public class UsuarioController {

    List<Usuario> usuarios = new ArrayList<>();
    Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    UsuarioRepository repository; // Injeção de dependencia

    @Autowired
    AuthenticationManager manager;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    TokenService tokenService;

    @GetMapping("/api/usuarios")
    public List<Usuario> index() {
        return repository.findAll();
    }

    @PostMapping("/api/login")
    public ResponseEntity<Object> login(@RequestBody @Valid Credencial credencial) {
        // usuario.setSenha(encoder.encode(usuario.getSenha()));
        // repository.save(usuario);
        manager.authenticate(credencial.toAuthentication());

        var token = tokenService.generateToken(credencial);
        return ResponseEntity.ok(token);
    }

    @PostMapping("/api/entrar")
    public ResponseEntity<Usuario> registrar(@RequestBody @Valid Usuario usuario) {
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    // @PostMapping("/api/usuarios")
    // public ResponseEntity<Usuario> create(@RequestBody @Valid Usuario usuario) {
    // log.info("usuario cadastrados" + usuarios);

    // repository.save(usuario);

    // return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    // }

    // @GetMapping("/api/usuarios/{id}")
    // public ResponseEntity<Usuario> show(@PathVariable int id){
    // log.info("buscando publicacoes com id: " + id);
    // var usuario = getUsuario(id);

    // return ResponseEntity.ok(usuario);
    // }

    // @DeleteMapping("/api/usuarios/{id}")
    // public ResponseEntity<Usuario> destroy(@PathVariable int id){
    // log.info("deletando usuarios com o id: " + id);
    // var usuario = getUsuario(id);

    // usuarios.remove(usuario);

    // return ResponseEntity.noContent().build();
    // }

    // @PutMapping("/api/usuarios/{id}")
    // public ResponseEntity<Usuario> update(@PathVariable int id, @RequestBody
    // @Valid Usuario usuario){
    // log.info("atualizando o id do login: " + id);
    // getUsuario(id);

    // usuario.setId(id);
    // repository.save(usuario);

    // return ResponseEntity.ok(usuario);
    // }

    // private Usuario getUsuario(int id) {
    // return repository.findById(id)
    // .orElseThrow(() -> new RestNotFoundException("Nenhum usuario encontrada no
    // sistema"));
    // }

}
