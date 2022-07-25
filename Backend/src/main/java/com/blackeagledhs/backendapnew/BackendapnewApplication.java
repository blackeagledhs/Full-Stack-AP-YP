package com.blackeagledhs.backendapnew;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;


@SpringBootApplication
public class BackendapnewApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendapnewApplication.class, args);
	}

	@Bean
	public CorsFilter corsFilter() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		final CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(false);
		config.setAllowedOrigins(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		config.setAllowedMethods(Arrays.stream(HttpMethod.values()).map(HttpMethod::name).collect(Collectors.toList()));
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}


}
