package br.com.api.controller;

import br.com.api.model.Cliente;
import br.com.api.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
	@Autowired
	ClienteRepository repository;

	@GetMapping({"/cliente"})
	public List<Cliente> getClientes() {
		return this.repository.findAll();
	}

	@PostMapping({"/insert/cliente"})
	public void insertCliente(@RequestBody Cliente cliente) {
		this.repository.save(cliente);
	}

	@PostMapping({"/update/cliente"})
	public void updateCliente(@RequestBody Cliente cliente) {
		this.repository.save(cliente);
	}

	@PostMapping({"/delete/cliente"})
	public void deleteCliente(@RequestBody Cliente cliente) {
		this.repository.delete(cliente);
	}
}