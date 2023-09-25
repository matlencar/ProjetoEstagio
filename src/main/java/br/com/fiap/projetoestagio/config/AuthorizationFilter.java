package br.com.fiap.projetoestagio.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.fiap.projetoestagio.service.TokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Component
public class AuthorizationFilter extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var token = getToken(request);

        if (token != null) {

            var usuario = tokenService.getValidateUseUsuario(token); // se nao for username é usuario
            Authentication auth = new UsernamePasswordAuthenticationToken(usuario.getUsername(), null,
                    usuario.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(auth);
        }

    }

    private String getToken(HttpServletRequest request) {
        var header = request.getHeader("Authorization");

        if (header == null || header.isEmpty() || !header.startsWith("Bearer ")) {
            return null;
    }

    return header.replace("Bearer ", "");
    
}
}