package br.com.fiap.projetoestagio.models;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

public record Credencial(String usuario, String senha) {

    public Authentication tAuthentication() {
        return new UsernamePasswordAuthenticationToken(usuario, senha);
    }
    
}
