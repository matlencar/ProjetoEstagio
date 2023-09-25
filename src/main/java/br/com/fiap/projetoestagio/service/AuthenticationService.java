package br.com.fiap.projetoestagio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.fiap.projetoestagio.models.Usuario;
import br.com.fiap.projetoestagio.repository.UsuarioRepository;

@Service
public class AuthenticationService implements UserDetailsService {
    
    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

       Usuario usuario = repository.findByEmail(username)
       .orElseThrow(() -> new UsernameNotFoundException(" Usuario não encontrado" + username));

       return usuario;
    }
}
