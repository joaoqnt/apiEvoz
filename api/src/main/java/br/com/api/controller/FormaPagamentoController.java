package br.com.api.controller;

import br.com.api.model.FormaPagamento;
import br.com.api.repository.FormaPagamentoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormaPagamentoController {
	@Autowired
	FormaPagamentoRepository repository;

	@GetMapping({"/formas"})
	public List<FormaPagamento> getFormas() {
		return this.repository.findAll();
	}

	@GetMapping({"/formas/"})
	public List<FormaPagamento> getFormasByAtivo(@RequestParam String ativo) {
		return this.repository.findAllByAtivo(ativo);
	}

	@PostMapping({"/insert/forma"})
	public void insertForma(@RequestBody FormaPagamento forma) {
		this.repository.save(forma);
	}

	@PostMapping({"/update/forma"})
	public void updateForma(@RequestBody FormaPagamento forma) {
		this.repository.save(forma);
	}

	@PostMapping({"/delete/forma"})
	public void deleteForma(@RequestBody FormaPagamento forma) {
		this.repository.delete(forma);
	}
}