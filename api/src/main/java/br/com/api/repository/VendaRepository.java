package br.com.api.repository;

import br.com.api.model.Venda;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VendaRepository extends JpaRepository<Venda, Long> {
	List<Venda> findAllByComanda(String comanda);

	@Query(value = "SELECT * FROM venda v WHERE STR_TO_DATE(v.data_pedido, '%Y-%m-%d') BETWEEN :dataInicio AND :dataFim", nativeQuery = true)
	List<Venda> findByDateInicialAndDateFinal(@Param("dataInicio") String dataInicio, @Param("dataFim") String dataFim);
}