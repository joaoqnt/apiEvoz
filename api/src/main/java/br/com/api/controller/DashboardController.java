package br.com.api.controller;

import br.com.api.repository.DashboardRepository;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DashboardController {
	@Autowired
	DashboardRepository repository;

	@GetMapping({"/diaVenda"})
	public List<Map<String, Object>> getDiaVendas(@RequestParam String dtIni, @RequestParam String dtEnd) {
		return this.repository.findDiaVendas(dtIni, dtEnd);
	}

	@GetMapping({"/produtoVenda"})
	public List<Map<String, Object>> getProdutoVendas(@RequestParam String dtIni, @RequestParam String dtEnd) {
		return this.repository.findProdutosVendas(dtIni, dtEnd);
	}

	@GetMapping({"/horaVenda"})
	public List<Map<String, Object>> getHoraVendas(@RequestParam String dtIni, @RequestParam String dtEnd) {
		return this.repository.findHorasVendas(dtIni, dtEnd);
	}

	@GetMapping({"/categoriaVenda"})
	public List<Map<String, Object>> getCategoriaVendas(@RequestParam String dtIni, @RequestParam String dtEnd) {
		return this.repository.findCategoriaMaisVendas(dtIni, dtEnd);
	}

	@GetMapping({"/ticketMedio"})
	public List<Map<String, Object>> getTicketMedio(@RequestParam String dtIni, @RequestParam String dtEnd) {
		return this.repository.findTicketMedio(dtIni, dtEnd);
	}

	@GetMapping({"/vendedorVenda"})
	public List<Map<String, Object>> getVendedorVenda(@RequestParam String dtIni, @RequestParam String dtEnd) {
		return this.repository.findVendedorMaisVendas(dtIni, dtEnd);
	}
}