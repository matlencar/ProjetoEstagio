package br.com.fiap.projetoestagio.controllers;


import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.projetoestagio.models.Publicacao;

@RestController
public class PublicacaoController {

    @GetMapping("/localhost/publicacao")
    @ResponseBody
    public Publicacao show() {

        Publicacao publicacao = new Publicacao(new String("Essa sera minnha primeira publicacao na plataforma, espero contrubuir muito com a comunidade dev"), LocalDate.now(), "Programando em java");

        return publicacao;
    }
}