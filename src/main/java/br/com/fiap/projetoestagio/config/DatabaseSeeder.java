package br.com.fiap.projetoestagio.config;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.projetoestagio.models.Cadastro;
import br.com.fiap.projetoestagio.models.InfoPublicacao;
import br.com.fiap.projetoestagio.models.Publicacao;
import br.com.fiap.projetoestagio.models.Usuario;
import br.com.fiap.projetoestagio.repository.CadastroRepository;
import br.com.fiap.projetoestagio.repository.InfoPublicacaoRepository;
import br.com.fiap.projetoestagio.repository.PublicacaoRepository;
import br.com.fiap.projetoestagio.repository.UsuarioRepository;

@Configuration
public class DatabaseSeeder implements CommandLineRunner {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PublicacaoRepository publicacaoRepository;

    @Autowired
    InfoPublicacaoRepository infoPublicacaoRepository;

    @Autowired
    CadastroRepository cadastroRepository;

    @Override
    public void run(String... args) throws Exception {

        Cadastro cadastro1 = new Cadastro(1, "matlencar222@gmail.com", "@mat123", "Matheus", "28/08/1994", "99988877711");
        Cadastro cadastro2 = new Cadastro(2, "pedrosanag999@gmail.com", "@ped123", "Pedro", "10/04/2002", "66644422299");
        Cadastro cadastro3 = new Cadastro(3, "mariaeli112@gmail.com", "@mari123", "Maria", "26/07/1994", "77455523298");
        cadastroRepository.saveAll(List.of(cadastro1, cadastro2, cadastro3));

        Usuario user1 = new Usuario(1, "Matheus", "matlencar", "@mat123", 29, "Develop backend", "Masculino",
                "99988877711", "442225551");
        Usuario user2 = new Usuario(2, "Pedro", "pedrosanag", "@ped123", 19, "Develop frontend", "Masculino",
                "66644422299", "113338887");
        Usuario user3 = new Usuario(3, "Maria", "mariaeli", "@mari123", 24, "Develop frontend", "Feminino",
                "77455523298", "223336669");
        usuarioRepository.saveAll(List.of(user1, user2, user3));

        InfoPublicacao infoDetails1 = new InfoPublicacao(1, "Node", "Backend Pleno Node");
        InfoPublicacao infoDetails2 = new InfoPublicacao(2, "Java", "Backend Pleno Java");
        InfoPublicacao infoDetails3 = new InfoPublicacao(3, "React", "Frontend Pleno React");
        infoPublicacaoRepository.saveAll(List.of(infoDetails1, infoDetails2, infoDetails3));

        Publicacao publicacao1 = new Publicacao(1,
                "Ola escrevi um artigo interessante sobre o node e suas funcionalidades", "Praticidades do node",
                infoDetails1);
        Publicacao publicacao2 = new Publicacao(2,
                "Ola escrevi um artigo interessante sobre o java e suas funcionalidades", "Praticidades do java",
                infoDetails2);
        Publicacao publicacao3 = new Publicacao(3,
                "Ola escrevi um artigo interessante sobre o react e suas funcionalidades", "Praticidades do react",
                infoDetails3);

        publicacaoRepository.saveAll(List.of(publicacao1, publicacao2, publicacao3));

    }
}
