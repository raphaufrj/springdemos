package br.com.resteasy.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@PropertySource({ "classpath:application.properties", })
public class ApplicationProperties {

	private Environment env;

	@Autowired
	public ApplicationProperties(Environment env) {
		this.env = env;
	}

	public String getMongodbURI() {
		return env.getProperty("spring.data.mongodb.uri");
	}
}
