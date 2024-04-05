package br.com.api.repository;

import br.com.api.model.Caixa;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CaixaRepository extends JpaRepository<Caixa, Long> {
	@Query(value = "select c.* from caixa c where c.usuario = :usuario order by c.data_inicio desc limit 1", nativeQuery = true)
	Optional<Caixa> getLast(@Param("usuario") int usuario);
}