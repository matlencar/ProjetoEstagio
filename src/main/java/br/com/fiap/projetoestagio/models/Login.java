package br.com.fiap.projetoestagio.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Email(message="Por favor forneça um endereço de email valido")
    @Pattern(regexp=".+@.+\\..+", message="Por favor forneça um endereço de email valido")
    private String usuario;

    @NotBlank
    @Size(min = 6, max = 8, message = "A senha deve conter entre 6 a 8 caracteres")
    private String senha;

    @OneToOne
    private Usuario user;

    public Login() {}
}
