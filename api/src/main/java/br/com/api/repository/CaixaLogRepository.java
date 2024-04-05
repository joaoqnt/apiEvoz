package br.com.api.repository;

import br.com.api.model.CaixaLog;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CaixaLogRepository extends JpaRepository<CaixaLog, Date> {
	@Query(value = "SELECT * FROM caixa_log v WHERE STR_TO_DATE(v.data_registro, '%Y-%m-%d') BETWEEN :dataInicio AND :dataFim", nativeQuery = true)
	List<CaixaLog> findByDateInicialAndDateFinal(@Param("dataInicio") String dataInicio,
			@Param("dataFim") String dataFim);
}