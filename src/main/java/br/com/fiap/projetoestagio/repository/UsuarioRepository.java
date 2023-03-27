package br.com.fiap.projetoestagio.repository;

import br.com.fiap.projetoestagio.models.Usuario;

public class UsuarioRepository extends JpaRepositoryUsuario<Usuario, Long>{

    public void save(Usuario usuario) {
    }

	public Object findById(Long id) {
		return id;
	}
    
}
