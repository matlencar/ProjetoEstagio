package br.com.fiap.projetoestagio.models;

import java.util.Optional;

public record PublicacaoDto (int id, String titulo, String texto) {
    
    // public PublicacaoDto(Publicacao publicacao, String titulo, String texto) {
    //     this(publicacao.getId(), publicacao.getTitulo(), publicacao.getTexto());
    // }

    public PublicacaoDto(Publicacao publicacao, Optional<String> titulo, Optional<String> texto) {
        this(publicacao.getId(), publicacao.getTitulo(), publicacao.getTexto());
    }
}
