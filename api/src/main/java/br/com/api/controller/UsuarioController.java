package br.com.api.controller;

import br.com.api.model.Usuario;
import br.com.api.repository.UsuarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {
	@Autowired
	UsuarioRepository repository;

	@GetMapping({"/usuario"})
	public Usuario getUsuario(@RequestParam String email, @RequestParam String senha) {
		return this.repository.findByEmailAndSenhaAndAtivo(email, senha, "true");
	}

	@GetMapping({"/filterUser"})
	public Optional<Usuario> getUsuarioById(@RequestParam long id) {
		return this.repository.findById(id);
	}

	@GetMapping({"/usuarios"})
	public List<Usuario> getAll() {
		return this.repository.findAll();
	}

	@PostMapping({"/insert/usuario"})
	public void insertUsuario(@RequestBody Usuario usuario) {
		this.repository.save(usuario);
	}

	@PostMapping({"/update/usuario"})
	public void updateUsuario(@RequestBody Usuario usuario) {
		this.repository.save(usuario);
	}
}