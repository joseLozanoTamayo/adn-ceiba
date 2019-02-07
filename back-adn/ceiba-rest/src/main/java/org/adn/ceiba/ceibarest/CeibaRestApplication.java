package org.adn.ceiba.ceibarest;

import org.adn.ceiba.ceibarest.entity.TipoVehiculo;
import org.adn.ceiba.ceibarest.repository.TipoVehiculoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

/**
 * Clase init de spring boot
 * 
 * @author jose.lozano
 *
 */
@SpringBootApplication(exclude= {SecurityAutoConfiguration.class})
public class CeibaRestApplication extends SpringBootServletInitializer {
	
	private static final Logger log = LoggerFactory.getLogger(CeibaRestApplication.class);

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CeibaRestApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CeibaRestApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo (TipoVehiculoRepository repository) {
		return (args) -> {
			// save a couple of customers
			
			TipoVehiculo v = new TipoVehiculo();
			v.setVehiculo("carro");
			repository.save(v);
//			repository.save(new Customer("Chloe", "O'Brian"));
//			repository.save(new Customer("Kim", "Bauer"));
//			repository.save(new Customer("David", "Palmer"));
//			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (TipoVehiculo customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			repository.findById(1)
					.ifPresent(customer -> {
						log.info("Customer found with findById(1L):");
						log.info("--------------------------------");
						log.info(customer.toString());
						log.info("");
					});

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("");
		};
	}

}
