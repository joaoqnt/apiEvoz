package br.com.api.config;

import br.com.api.config.tenant.TenantContext;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicRoutingDataSource extends AbstractRoutingDataSource {
	protected Object determineCurrentLookupKey() {
		return TenantContext.getCurrentTenant();
	}
}