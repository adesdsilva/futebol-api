package br.com.sunsystem.partida_futebolapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final String BASE_PACKAGE = "br.com.sunsystem.partida_futebolapi";
	private static final String API_TITULO = "Futebol API - Scraping";
	private static final String API_DESCRICAO = "API REST que capta dados de partidas de futebol";
	private static final String API_VERSAO = "1.0.0";
	private static final String CONTATO_NOME = "Adelino Santos da Silva";
	private static final String CONTATO_GITHUB = "https://github.com/adesdsilva";
	private static final String CONTATO_EMAIL = "adesdsilva@gmail.com";
	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(buildApiInfo());
	}

	private ApiInfo buildApiInfo() {
		
		return new ApiInfoBuilder()
				.title(API_TITULO)
				.description(API_DESCRICAO)
				.version(API_VERSAO)
				.contact(new Contact(CONTATO_NOME, CONTATO_GITHUB, CONTATO_EMAIL))
				.build();
	}
	
	
}
