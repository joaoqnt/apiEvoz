package br.com.api.repository;

import br.com.api.model.ProdutoTamanho;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoTamanhoRepository extends JpaRepository<ProdutoTamanho, Long> {
	@Modifying
	@Transactional
	@Query(value = "delete from produto_tamanho c where c.produto = :produto", nativeQuery = true)
	void deleteByProduto(long produto);
}