package br.com.api.repository;

import br.com.api.model.Licenca;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LicencaRepository extends JpaRepository<Licenca, Long> {
	List<Licenca> findAllByAtivo(String ativo);
}