package br.com.fiap.projetoestagio.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.fiap.projetoestagio.models.Credencial;
import br.com.fiap.projetoestagio.models.Token;
import br.com.fiap.projetoestagio.models.Usuario;
import br.com.fiap.projetoestagio.repository.UsuarioRepository;
import jakarta.validation.Valid;

@Service
public class TokenService {

    @Autowired
    UsuarioRepository repository;

    @Value("${jwt.secret}")
    String secret;

    public Token generateToken(@Valid Credencial credencial) {

        Algorithm alg = Algorithm.HMAC256(secret);
        String token = JWT.create()
        .withSubject(credencial.usuario())
        .withIssuer("pi")
        .withExpiresAt(Instant.now().plus(1, ChronoUnit.HOURS))
        .sign(alg);

        return new Token(token, "JWT", "Bearer ");
    }

    public Usuario getValidateUseUsuario (String token) {
        Algorithm alg = Algorithm.HMAC256(secret);
        var username = JWT.require(alg)
        .withIssuer("pi")
        .build()
        .verify(token)
        .getSubject();

       return repository.findByUsername(username)
       .orElseThrow(() -> new JWTVerificationException("Ola, o usuario é invalido"));
    }
    
}
