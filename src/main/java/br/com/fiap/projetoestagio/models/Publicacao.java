package br.com.fiap.projetoestagio.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 5, max = 200, message = "O texto deve ter no minimo 5 letras e no maximo 200 letras")
    @NotBlank
    private String texto;

    @NotBlank
    private LocalDate data;

    @Size(min = 5, max = 100, message = "O titulo da postagem deve conter entre 5 a 100 letras")
    @NotBlank
    private String titulo;
    
    protected Publicacao() {}
    
    public Publicacao(Long id, String texto, LocalDate data, String titulo) {
        this.id = id;
        this.texto = texto;
        this.data = data;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
