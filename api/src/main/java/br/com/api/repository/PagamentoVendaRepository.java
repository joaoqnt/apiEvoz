package br.com.api.repository;

import br.com.api.model.PagamentoVenda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PagamentoVendaRepository extends JpaRepository<PagamentoVenda, Long> {
	@Query(value = "select pv.* from pagamento_venda pv where pv.venda in :vendas", nativeQuery = true)
	List<PagamentoVenda> findByVendas(@Param("vendas") List<Long> vendas);
}