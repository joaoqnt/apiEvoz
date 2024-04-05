package br.com.api.controller;

import br.com.api.model.CabCombo;
import br.com.api.repository.CabComboRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CabComboController {
	@Autowired
	CabComboRepository repository;

	@GetMapping({"combos"})
	public List<CabCombo> getCombos() {
		return this.repository.findAll();
	}

	@PostMapping({"/insert/combo"})
	public long createCombo(@RequestBody CabCombo combo) {
		this.repository.save(combo);
		return combo.getId();
	}

	@PostMapping({"/update/combo"})
	public void updateCombo(@RequestBody CabCombo combo) {
		this.repository.save(combo);
	}
}