package br.com.api.controller;

import br.com.api.model.Empresa;
import br.com.api.repository.EmpresaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpresaController {
	@Autowired
	EmpresaRepository repository;

	@GetMapping({"empresa"})
	public List<Empresa> getEmpresas() {
		return this.repository.findAll();
	}

	@PostMapping({"update/empresa"})
	public void updateEmpresa(@RequestBody Empresa empresa) {
		this.repository.save(empresa);
	}
}