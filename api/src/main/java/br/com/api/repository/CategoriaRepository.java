package br.com.api.repository;

import br.com.api.model.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
	List<Categoria> findAllByAtivo(String ativo);
}