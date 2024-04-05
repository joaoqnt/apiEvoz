package br.com.api.controller;

import br.com.api.model.ItemCombo;
import br.com.api.repository.ItemComboRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemComboController {
	@Autowired
	ItemComboRepository repository;

	@GetMapping({"itensCombo"})
	public List<ItemCombo> getItens() {
		return this.repository.findAll();
	}

	@PostMapping({"insert/itemCombo"})
	public void postItemCombo(@RequestBody ItemCombo item) {
		this.repository.save(item);
	}

	@PostMapping({"update/itemCombo"})
	public void updateItemCombo(@RequestBody ItemCombo item) {
		this.repository.save(item);
	}

	@PostMapping({"delete/itemCombo"})
	public void deleteItemCombo(@RequestParam long combo) {
		this.repository.deleteByCombo(combo);
	}
}