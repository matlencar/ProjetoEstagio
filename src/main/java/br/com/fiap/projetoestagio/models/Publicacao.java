package br.com.fiap.projetoestagio.models;

import java.time.LocalDate;

public class Publicacao {
    private String texto;
    private LocalDate data;
    private String titulo;
    
    
    public Publicacao(String texto, LocalDate data, String titulo) {
        this.texto = texto;
        this.data = data;
        this.titulo = titulo;
    }


    public String getTexto() {
        return texto;
    }


    public void setTexto(String texto) {
        this.texto = texto;
    }


    public LocalDate getData() {
        return data;
    }


    public void setData(LocalDate data) {
        this.data = data;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "Publicacao [texto=" + texto + ", data=" + data + ", titulo=" + titulo + "]";
    }

}
