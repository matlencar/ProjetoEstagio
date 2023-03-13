package br.com.fiap.projetoestagio.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.models.Login;
@RestController
public class LoginController {

    @GetMapping("/localhost/login")
    @ResponseBody
    public Login showLogin() {

        Login login = new Login("matheus@email.com", "10288ASw");

        return login;

    }
}
