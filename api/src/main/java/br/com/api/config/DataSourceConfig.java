package br.com.api.config;

import br.com.api.model.Licenca;
import br.com.api.service.ImageService;
import br.com.api.singleton.LicencaSingleton;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class DataSourceConfig {
	private List<Licenca> licencas = new ArrayList();
	ImageService imageService = new ImageService();

	@PostConstruct
	public void init() {
		this.addLicenca("evozw_migs", "jdbc:mysql://joaoqnt.ddns.net:3306/migs?useTimezone=true&serverTimezone=UTC",
				"sysdba", "Senha123***", "S");
		this.addLicenca("evozw_03683003000165",
				"jdbc:mysql://joaoqnt.ddns.net:3306/03683003000165?useTimezone=true&serverTimezone=UTC", "sysdba",
				"Senha123***", "S");
		this.addLicenca("evozw_marques_store",
				"jdbc:mysql://joaoqnt.ddns.net:3306/marques_store?useTimezone=true&serverTimezone=UTC", "sysdba",
				"Senha123***", "S");
	}

	@Bean
	@Scheduled(fixedRate = 60000L)
	public AbstractRoutingDataSource routingDataSource() {
		DynamicRoutingDataSource routingDataSource = new DynamicRoutingDataSource();
		Map<Object, Object> targetDataSource = new HashMap();
		this.licencas.forEach((licenca) -> {
			if (licenca.getAtivo().equals("S")) {
				DataSource dataSource = this.createDataSource(licenca);
				targetDataSource.put(licenca.getKey(), dataSource);
			}

		});
		routingDataSource.setTargetDataSources(targetDataSource);
		routingDataSource.setDefaultTargetDataSource(targetDataSource.values().iterator().next());
		return routingDataSource;
	}

	private DataSource createDataSource(Licenca licenca) {
		return DataSourceBuilder.create().url(licenca.getUrl()).username(licenca.getUsername())
				.password(licenca.getPassword()).driverClassName("com.mysql.cj.jdbc.Driver").build();
	}

	private void addLicenca(String key, String url, String username, String password, String ativo) {
		Licenca licenca = new Licenca();
		licenca.setKey(key);
		licenca.setUrl(url);
		licenca.setUsername(username);
		licenca.setPassword(password);
		licenca.setAtivo(ativo);
		this.licencas.add(licenca);
		LicencaSingleton.getInstance().addLicenca(licenca);
		this.imageService.createDirectory(key.replace("evozw_", ""));
	}
}