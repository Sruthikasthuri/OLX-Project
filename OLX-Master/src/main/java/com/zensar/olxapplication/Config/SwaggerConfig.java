package com.zensar.olxapplication.Config;

import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

public class SwaggerConfig {
	@Bean
	public Docket getCustomizedDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.zensar.olxapplication"))
				.build()
				.apiInfo(getApiInfo());
	}
	@SuppressWarnings("deprecation")
	private ApiInfo getApiInfo() {

		return new ApiInfo("olxapplication", "This is to MasterUsers", "5.6.6", "http://www.zensar.com",
				"sruthikasthuri", " "," ");
	}
}
