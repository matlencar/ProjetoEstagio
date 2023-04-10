package br.com.fiap.projetoestagio.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Data
@ToString
@Setter
@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
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

    @OneToMany
    private Usuario usuario;
    
    protected Publicacao() {}
    
    
}
