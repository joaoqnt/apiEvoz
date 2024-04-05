package br.com.api.controller;

import br.com.api.model.Categoria;
import br.com.api.repository.CategoriaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoriaController {
	@Autowired
	CategoriaRepository repository;

	@GetMapping({"/categoria"})
	public List<Categoria> getCategorias() {
		return this.repository.findAll();
	}

	@PostMapping({"/insert/categoria"})
	public void insertCategoria(@RequestBody Categoria categoria) {
		this.repository.save(categoria);
	}

	@PostMapping({"/delete/categoria"})
	public void deleteCategoria(@RequestBody Categoria categoria) {
		this.repository.delete(categoria);
	}

	@PostMapping({"/update/categoria"})
	public void updateCategoria(@RequestBody Categoria categoria) {
		this.repository.save(categoria);
	}
}