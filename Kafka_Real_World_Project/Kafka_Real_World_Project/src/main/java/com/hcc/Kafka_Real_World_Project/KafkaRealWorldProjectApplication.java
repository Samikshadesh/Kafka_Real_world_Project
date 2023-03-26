package com.hcc.Kafka_Real_World_Project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("KafkaRealWorldProjectApplication")
public class KafkaRealWorldProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaRealWorldProjectApplication.class, args);
	}

}
