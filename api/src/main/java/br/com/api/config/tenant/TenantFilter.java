package br.com.api.config.tenant;

import br.com.api.ApiApplication;
import br.com.api.singleton.LicencaSingleton;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TenantFilter implements Filter {
	private static Logger logger = LoggerFactory.getLogger(ApiApplication.class);

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String[] parts = request.getRequestURI().split("/");
		if (parts.length >= 2) {
			String tenant = parts[2];
			if (this.isValidTenant(tenant)) {
				TenantContext.setCurrentTenant(tenant);

				try {
					String path = "/" + String.join("/", (CharSequence[]) Arrays.copyOfRange(parts, 3, parts.length));
					System.out.println(path);
					request.getRequestDispatcher(path).forward(request, response);
					logger.info(tenant + "->" + path);
				} finally {
					TenantContext.clear();
				}
			} else {
				logger.warn(tenant + " nao existe");
				response.setStatus(400);
			}
		} else {
			response.setStatus(400);
		}

	}

	private boolean isValidTenant(String tenant) {
		return LicencaSingleton.getInstance().getLicencas().stream().anyMatch((l) -> {
			return l.getKey().equals(tenant);
		});
	}
}