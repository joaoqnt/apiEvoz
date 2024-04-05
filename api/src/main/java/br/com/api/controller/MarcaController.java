package br.com.api.controller;

import br.com.api.model.Marca;
import br.com.api.repository.MarcaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarcaController {
	@Autowired
	MarcaRepository repository;

	@GetMapping({"/marca"})
	public List<Marca> getMarcas() {
		return this.repository.findAll();
	}

	@PostMapping({"/insert/marca"})
	public void insertMarca(@RequestBody Marca marca) {
		this.repository.save(marca);
	}

	@PostMapping({"/update/marca"})
	public void updateMarca(@RequestBody Marca marca) {
		this.repository.save(marca);
	}

	@PostMapping({"/delete/marca"})
	public void deleteMarca(@RequestBody Marca marca) {
		this.repository.delete(marca);
	}
}