package br.com.api.controller;

import br.com.api.model.Venda;
import br.com.api.repository.VendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendaController {
	@Autowired
	VendaRepository repository;

	@PostMapping({"/insert/venda"})
	public long insertVenda(@RequestBody Venda venda) {
		this.repository.save(venda);
		return venda.getId();
	}

	@GetMapping({"/vendas"})
	public List<Venda> getVendas(@RequestParam String dataInicio, @RequestParam String dataFim) {
		return this.repository.findByDateInicialAndDateFinal(dataInicio, dataFim);
	}

	@PostMapping({"/update/venda"})
	public long updateVenda(@RequestBody Venda venda) {
		this.repository.save(venda);
		return venda.getId();
	}

	@GetMapping({"/comandas"})
	public List<Venda> getVendasComandas(@RequestParam String comanda) {
		return this.repository.findAllByComanda(comanda);
	}
}