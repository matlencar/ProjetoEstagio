package br.com.fiap.projetoestagio.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.projetoestagio.models.Publicacao;
import br.com.fiap.projetoestagio.models.Usuario;
import br.com.fiap.projetoestagio.repository.PublicacaoRepository;
import br.com.fiap.projetoestagio.repository.UsuarioRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Override
    public void run(String... args) throws Exception {
       
        Usuario user1 = new Usuario(1L, "Matheus", 28, "gosto de java", "Masculino", "11122233300", "98765", args, "oi", "matheusLencar", "29012");

        Usuario user2 = new Usuario(2L, "Pedro", 19, "gosto de react", "Masculino", "11122233300", "98765", args, "ola", "pedroSanag", "89012");

        usuarioRepository.saveAll(List.of(user1, user2));

        publicacaoRepository.saveAll(List.of(
            Publicacao.builder().texto("Ola a todos").titulo("Boas vindas").data(LocalDate.now()).usuario(user1).build(),
            Publicacao.builder().texto("Ola a todos").titulo("Boas vindas").data(LocalDate.now()).usuario(user2).build()
             ));
    }
}
