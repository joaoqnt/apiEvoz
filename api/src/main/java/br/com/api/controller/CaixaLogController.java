package br.com.api.controller;

import br.com.api.model.CaixaLog;
import br.com.api.repository.CaixaLogRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CaixaLogController {
	@Autowired
	CaixaLogRepository repository;

	@GetMapping({"/caixaLogs"})
	public List<CaixaLog> getVendas(@RequestParam String dataInicio, @RequestParam String dataFim) {
		return this.repository.findByDateInicialAndDateFinal(dataInicio, dataFim);
	}
}