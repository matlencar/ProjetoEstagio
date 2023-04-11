package br.com.fiap.projetoestagio.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.projetoestagio.models.Usuario;
import br.com.fiap.projetoestagio.repository.PublicacaoRepository;
import br.com.fiap.projetoestagio.repository.UsuarioRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    
    UsuarioRepository usuarioRepository;

    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Override
    public void run(String... args) throws Exception {
        usuarioRepository.saveAll(List.of(
            new Usuario()
            
        ));
    }
}
