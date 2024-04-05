package br.com.api.repository;

import br.com.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByEmailAndSenhaAndAtivo(String email, String senha, String ativo);

	Usuario findByEmail(String email);
}