package br.com.fiap.projetoestagio.config;

public class RestNotFoundException extends RuntimeException {
    
    public RestNotFoundException(String message) {
        super(message);
    }
}
