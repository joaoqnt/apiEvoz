package br.com.api.controller;

import br.com.api.model.ItemVenda;
import br.com.api.repository.ItemVendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemVendaController {
	@Autowired
	ItemVendaRepository repository;

	@PostMapping({"/insert/item"})
	public void insertItemVenda(@RequestBody ItemVenda item) {
		this.repository.save(item);
	}

	@GetMapping({"/itens"})
	public List<ItemVenda> getItens(@RequestParam List<Long> vendas) {
		return this.repository.findByVendas(vendas);
	}

	@PostMapping({"/delete/item"})
	public void deleteItemVenda(@RequestParam long venda) {
		this.repository.deleteByVenda(venda);
	}
}