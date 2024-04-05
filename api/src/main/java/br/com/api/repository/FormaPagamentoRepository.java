package br.com.api.repository;

import br.com.api.model.FormaPagamento;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {
	List<FormaPagamento> findAllByAtivo(String ativo);
}