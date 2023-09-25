package br.com.fiap.projetoestagio.models;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

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
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // @NotBlank
    // @Size(max = 60, message = "O nome deve conter até 60 caracteres")
    // private String nome;

    @NotBlank
    @Size(max = 80)
    private String email;

    @NotBlank
    @Size(max = 80)
    private String senha;

     @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_CLIENTE"));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    // @NotNull
    // @Size(max = 100)
    // private int idade;

    // @NotBlank
    // @Size(min = 1, max = 600, message = "O usuario pode fazer uma descrição que tenha até 600 caracteres")
    // private String descricao;

    // @NotBlank
    // @Min(value = 20, message = "deve digitar se pertence ao genero Masculino ou Feminino")
    // private String genero;

    // @NotBlank
    // @Max(value = 50, message = "Deve conter todos os 11 digitos do CPF")
    // private String cpf;

    // @NotBlank
    // @Max(value = 50, message = "Deve conter todos os 9 digitos do RG")
    // private String rg;

}
