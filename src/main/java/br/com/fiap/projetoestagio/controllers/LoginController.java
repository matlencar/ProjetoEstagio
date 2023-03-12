package br.com.fiap.projetoestagio.controllers;

import br.com.fiap.projetoestagio.models.Login;

public class LoginController {

    public Login showLogin() {

        Login login = new Login("matheus@email.com", "10288ASw");

        return login;

    }
}
