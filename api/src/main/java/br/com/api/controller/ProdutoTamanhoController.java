package br.com.api.controller;

import br.com.api.model.ProdutoTamanho;
import br.com.api.repository.ProdutoTamanhoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoTamanhoController {
	@Autowired
	ProdutoTamanhoRepository repository;

	@GetMapping({"/produtoTamanho"})
	public List<ProdutoTamanho> getTamanhos() {
		return this.repository.findAll();
	}

	@PostMapping({"/insert/produtoTamanho"})
	public void insertTamanho(@RequestBody ProdutoTamanho tamanho) {
		this.repository.save(tamanho);
	}

	@PostMapping({"/update/produtoTamanho"})
	public void updateTamanho(@RequestBody ProdutoTamanho tamanho) {
		this.repository.save(tamanho);
	}

	@PostMapping({"delete/produtoTamanho"})
	public void deleteTamanho(@RequestParam long produto) {
		this.repository.deleteByProduto(produto);
	}
}