package br.com.api.repository;

import br.com.api.model.Estoque;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EstoqueRepository extends JpaRepository<Estoque, Long> {
	@Query(value = "SELECT * FROM estoque v WHERE STR_TO_DATE(v.data_alteracao, '%Y-%m-%d') BETWEEN :dataInicio AND :dataFim", nativeQuery = true)
	List<Estoque> findByDateInicialAndDateFinal(@Param("dataInicio") String dataInicio,
			@Param("dataFim") String dataFim);
}