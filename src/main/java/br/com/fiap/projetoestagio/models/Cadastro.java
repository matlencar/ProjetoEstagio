package br.com.fiap.projetoestagio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Entity
public class Cadastro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank
    @Size(max = 80)
    private String email;

    @NotBlank
    @Size(max = 80, message = "A senha deve conter entre 6 a 8 caracteres")
    private String senha;

    @NotBlank
    @Size(max = 60, message = "O nome deve conter de 3 até 60 caracteres")
    private String nome;

    @NotBlank
    @Size(max = 100)
    private String dataNascimento;

    @NotBlank
    @Size(max = 19, message = "O CPF do usuario deve conter todos os 11 digitos completos")
    private String cpf;

}
