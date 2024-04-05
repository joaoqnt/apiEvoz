package br.com.api.controller;

import br.com.api.model.Produto;
import br.com.api.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {
	@Autowired
	ProdutoRepository repository;

	@GetMapping({"/produto"})
	public List<Produto> getProdutos() {
		return this.repository.findAll();
	}

	@GetMapping({"/produto/"})
	public List<Produto> getProdutosAtivos(@RequestParam String ativo) {
		return this.repository.findAllByAtivo(ativo);
	}

	@PostMapping({"/insert/produto"})
	public long insertProduto(@RequestBody Produto produto) {
		this.repository.save(produto);
		return produto.getId();
	}

	@PostMapping({"/delete/produto"})
	public void deleteProduto(@RequestBody Produto produto) {
		this.repository.delete(produto);
	}

	@PostMapping({"/update/produto"})
	public void updateProduto(@RequestBody Produto produto) {
		this.repository.save(produto);
	}
}