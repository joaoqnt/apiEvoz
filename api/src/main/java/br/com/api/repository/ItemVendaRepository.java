package br.com.api.repository;

import br.com.api.model.ItemVenda;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long> {
	List<ItemVenda> findAllByVenda(long venda);

	@Query(value = "select iv.* from item_venda iv where iv.venda in :vendas", nativeQuery = true)
	List<ItemVenda> findByVendas(@Param("vendas") List<Long> vendas);

	@Modifying
	@Transactional
	@Query(value = "delete from item_venda c where c.venda = :venda", nativeQuery = true)
	void deleteByVenda(long venda);
}