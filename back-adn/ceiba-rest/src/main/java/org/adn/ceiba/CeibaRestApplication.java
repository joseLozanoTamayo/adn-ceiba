package org.adn.ceiba;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Clase init de spring boot
 * 
 * @author jose.lozano
 *
 */
@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class CeibaRestApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CeibaRestApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CeibaRestApplication.class, args);
	}

}
