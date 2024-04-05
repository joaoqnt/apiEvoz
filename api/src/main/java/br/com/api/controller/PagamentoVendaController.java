package br.com.api.controller;

import br.com.api.model.PagamentoVenda;
import br.com.api.repository.PagamentoVendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoVendaController {
	@Autowired
	PagamentoVendaRepository repository;

	@PostMapping({"/insert/pagamentoVenda"})
	public void insertVenda(@RequestBody PagamentoVenda pagamento) {
		this.repository.save(pagamento);
	}

	@GetMapping({"/pagamentoVendas"})
	public List<PagamentoVenda> getPagamentoVendas(@RequestParam List<Long> vendas) {
		return this.repository.findByVendas(vendas);
	}
}