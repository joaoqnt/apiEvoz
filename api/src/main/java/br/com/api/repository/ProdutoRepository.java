package br.com.api.repository;

import br.com.api.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	List<Produto> findAll();

	List<Produto> findAllByAtivo(String ativo);
}