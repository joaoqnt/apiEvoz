package br.com.api.controller;

import br.com.api.model.Caixa;
import br.com.api.repository.CaixaRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaixaController {
	@Autowired
	CaixaRepository repository;

	@PostMapping({"/insert/caixa"})
	public void insertCaixa(@RequestBody Caixa caixa) {
		this.repository.save(caixa);
	}

	@GetMapping({"caixa/aberto"})
	public Optional<Caixa> getLast(@RequestParam int usuario) {
		return this.repository.getLast(usuario);
	}

	@PostMapping({"/update/caixa"})
	public void updateCaixa(@RequestBody Caixa caixa) {
		this.repository.save(caixa);
	}
}