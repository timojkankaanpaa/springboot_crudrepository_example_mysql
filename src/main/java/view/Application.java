package view;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import model.Order;
import repository.OrderRepository;

//SQL: CREATE TABLE IF NOT EXISTS `order` (`id` int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT, `customer` int(11) NOT NULL, `date` timestamp NULL DEFAULT NULL, `payment` int(11) DEFAULT NULL );
// taskkill /f /im javaw.exe
@EntityScan("model")
@EnableJpaRepositories("repository")	//enables to have a separate package for repos
@SpringBootApplication
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}
	
	
	@Bean
	public CommandLineRunner demo(repository.OrderRepository repository) {
		return (args) -> {
			// save a couple of customers
			Order order = new Order();
			order.setCustomer(1);
			java.util.Date utilDate = new java.util.Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(utilDate);
			cal.set(Calendar.MILLISECOND, 0);		
			order.setDate(new java.sql.Timestamp(cal.getTimeInMillis()));
			order.setPayment(1);
			//repository.delete(1);
			repository.save(order);
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Order order1 : repository.findAll()) {
				log.info(order1.toString());
			}
			log.info("");
		};
	}
}