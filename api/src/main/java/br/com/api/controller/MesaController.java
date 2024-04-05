package br.com.api.controller;

import br.com.api.model.Mesa;
import br.com.api.repository.MesaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MesaController {
	@Autowired
	MesaRepository repository;

	@GetMapping({"/mesas"})
	public List<Mesa> getMesas() {
		return this.repository.findAll();
	}

	@PostMapping({"/insert/mesa"})
	public void insertMesa(@RequestBody Mesa mesa) {
		this.repository.save(mesa);
	}

	@PostMapping({"/update/mesa"})
	public void updateMesa(@RequestBody Mesa mesa) {
		this.repository.save(mesa);
	}

	@PostMapping({"/delete/mesa"})
	public void deleteMesa(@RequestBody Mesa mesa) {
		this.repository.delete(mesa);
	}
}