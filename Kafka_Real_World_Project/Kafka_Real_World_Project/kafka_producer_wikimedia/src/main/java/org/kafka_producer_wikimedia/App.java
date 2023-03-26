package org.kafka_producer_wikimedia;

import org.kafka_producer_wikimedia.service.WikiMediaChangesProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Autowired
	WikiMediaChangesProducer wikiMediaChangesProducer;

	@Override
	public void run(String... args) throws Exception {
		wikiMediaChangesProducer.sendMessage();
		
	}

}
