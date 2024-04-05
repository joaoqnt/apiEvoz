package br.com.api.controller;

import br.com.api.model.Estoque;
import br.com.api.repository.EstoqueRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EstoqueController {
	@Autowired
	EstoqueRepository repository;

	@PostMapping({"/insert/estoque"})
	public void insertEstoque(@RequestBody Estoque estoque) {
		this.repository.save(estoque);
	}

	@GetMapping({"/estoques"})
	public List<Estoque> getEstoque(@RequestParam String dataInicio, @RequestParam String dataFim) {
		return this.repository.findByDateInicialAndDateFinal(dataInicio, dataFim);
	}
}