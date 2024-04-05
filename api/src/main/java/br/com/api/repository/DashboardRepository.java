package br.com.api.repository;

import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DashboardRepository {
	private final JdbcTemplate jdbcTemplate;

	public DashboardRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Map<String, Object>> findDiaVendas(String dataIni, String dataEnd) {
		this.jdbcTemplate.execute("SET lc_time_names = 'pt_BR';");
		String sql = "SELECT\tDAYNAME(v.data_pedido) as dia_da_semana,     sum(v.valor_liquido) as total, \tDAYOFWEEK(v.data_pedido) as dia_semana_numero FROM venda v WHERE STR_TO_DATE(v.data_pedido, '%Y-%m-%d') BETWEEN ? AND ? GROUP BY dia_da_semana, dia_semana_numero ORDER BY dia_semana_numero;";
		return this.jdbcTemplate.queryForList(sql, new Object[]{dataIni, dataEnd});
	}

	public List<Map<String, Object>> findProdutosVendas(String dataIni, String dataEnd) {
		String sql = "select \tiv.nome_produto ,\tsum(iv.quantidade) as total_qtd ,\tsum(iv.preco) as total_vendido from item_venda iv \tinner join venda v on (v.id = iv.venda and STR_TO_DATE(v.data_pedido, '%Y-%m-%d') BETWEEN ? and ?) group by iv.nome_produto ORDER BY sum(iv.quantidade) DESC limit 5";
		return this.jdbcTemplate.queryForList(sql, new Object[]{dataIni, dataEnd});
	}

	public List<Map<String, Object>> findHorasVendas(String dataIni, String dataEnd) {
		String sql = "select     HOUR(v.data_pedido) as data_pedido,     count(v.id) as qtd_pedido from venda v where STR_TO_DATE(v.data_pedido, '%Y-%m-%d') BETWEEN ? and ? group by HOUR(v.data_pedido) order by count(v.id) desc limit 5";
		return this.jdbcTemplate.queryForList(sql, new Object[]{dataIni, dataEnd});
	}

	public List<Map<String, Object>> findTicketMedio(String dataIni, String dataEnd) {
		String sql = "select avg(v.valor_liquido) as ticket_medio from venda v WHERE STR_TO_DATE(v.data_pedido, '%Y-%m-%d') BETWEEN ? AND ?;";
		return this.jdbcTemplate.queryForList(sql, new Object[]{dataIni, dataEnd});
	}

	public List<Map<String, Object>> findVendedorMaisVendas(String dataIni, String dataEnd) {
		String sql = "select \tu.nome from venda v \tinner join usuario u on (u.id = v.usuario) WHERE STR_TO_DATE(v.data_pedido, '%Y-%m-%d') BETWEEN ? AND ? group by 1 order by count(*) desc limit 1";
		return this.jdbcTemplate.queryForList(sql, new Object[]{dataIni, dataEnd});
	}

	public List<Map<String, Object>> findCategoriaMaisVendas(String dataIni, String dataEnd) {
		String sql = "select \tc.nome from item_venda iv \tinner join venda v on (v.id = iv.venda and STR_TO_DATE(v.data_pedido, '%Y-%m-%d') BETWEEN ? AND ?) \tinner join produto p on (p.id = iv.produto) \tINNER join categoria c on (c.id = p.categoria) group by 1 order by count(*) desc limit 1";
		return this.jdbcTemplate.queryForList(sql, new Object[]{dataIni, dataEnd});
	}
}