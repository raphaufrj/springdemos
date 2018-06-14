package br.com.resteasy.app.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.resteasy.app.formatter.CEPFormatAnnotationFormatterFactory;
import br.com.resteasy.app.formatter.CNPJFormatAnnotationFormatterFactory;
import br.com.resteasy.app.formatter.PhoneFormatAnnotationFormatterFactory;

@Configuration
@ComponentScan(basePackages = "br.com.resteasy")
@EnableMongoRepositories({ "br.com.resteasy.app.repositories" })
public class ApplicationConfig implements WebMvcConfigurer {
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatterForFieldAnnotation(new PhoneFormatAnnotationFormatterFactory());
		registry.addFormatterForFieldAnnotation(new CNPJFormatAnnotationFormatterFactory());
		registry.addFormatterForFieldAnnotation(new CEPFormatAnnotationFormatterFactory());
	}
}
