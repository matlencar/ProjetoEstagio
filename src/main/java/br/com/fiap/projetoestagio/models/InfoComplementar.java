package br.com.fiap.projetoestagio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@Entity
public class InfoComplementar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 2, max = 14, message = "Deve conter entre 2 e 14 caracteres")
    private String linguagem;

    @NotBlank
    @Size(min = 1, max = 3, message = "O nivel da linguagem deve ser de 1 até 3")
    private int nivelLinguagem;

    @NotBlank
    @Size(min = 2, max = 14, message = "Deve conter entre 2 e 14 caracteres")
    private String idioma;

    @NotBlank
    @Size(min = 1, max = 3, message = "O nivel da linguagem deve ser de 1 até 3")
    private int nivelIdioma;

    public InfoComplementar() {}

    

}
