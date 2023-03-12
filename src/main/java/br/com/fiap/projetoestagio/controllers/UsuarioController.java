package br.com.fiap.projetoestagio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.models.Usuario;

@RestController
public class UsuarioController {
    
    @GetMapping("/api/usuario")
    @ResponseBody
    public Usuario showUsuario() {

        Usuario user = new Usuario("Matheus", 28, "Ola me chamo matheus e quero ser um desenvolvedor frontend", "Masculino",185784212 , 848578457, null);

        return user;
    }
}
