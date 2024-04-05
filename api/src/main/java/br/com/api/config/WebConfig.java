package br.com.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		requestFactory.setConnectTimeout(5000);
		requestFactory.setReadTimeout(5000);
		return new RestTemplate(requestFactory);
	}

	@Configuration
	public class CorsConfig implements WebMvcConfigurer {
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**").allowedOrigins(new String[]{"*"})
					.allowedMethods(new String[]{"GET", "POST", "PUT", "DELETE", "OPTIONS"})
					.allowedHeaders(
							new String[]{"tenant", "Content-Type", "Access-Control-Allow-Headers", "Authorization"})
					.maxAge(3600L);
		}
	}
}