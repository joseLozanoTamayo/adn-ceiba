package org.adn.ceiba.ceibarest;


import org.adn.ceiba.ceibarest.entity.Book;
import org.adn.ceiba.ceibarest.entity.Publication;
import org.adn.ceiba.ceibarest.repository.BookRepository;
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
	public CommandLineRunner demo (BookRepository repository) {
		return args -> {
			// save a couple of customers
			
			
			Publication p = new Book();
			p.setId(1L);
			p.setTitle("luis es mi parcero del alma");
			
			repository.save( p );
//			TipoVehiculo v = new Test3();
//			v.setVehiculo("carro");
//			
//			
//			repository.save(v);
//
//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			log.info("");
//
//			// fetch an individual customer by ID
//			repository.findById(1)
//					.ifPresent(customer -> {
//						log.info("Customer found with findById(1L):");
//						log.info("--------------------------------");
//						log.info(customer.toString());
//						log.info("");
//					});
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("");
		};
	}

}
