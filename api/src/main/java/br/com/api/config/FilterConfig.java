package br.com.api.config;

import br.com.api.config.tenant.TenantFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
	@Bean
	public FilterRegistrationBean<TenantFilter> tenantFilter() {
		FilterRegistrationBean<TenantFilter> registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new TenantFilter());
		registrationBean.addUrlPatterns(new String[]{"/*"});
		return registrationBean;
	}
}