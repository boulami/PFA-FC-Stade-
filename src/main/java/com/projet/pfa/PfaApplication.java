package com.projet.pfa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableMongoRepositories(basePackages = "com.projet.pfa.repositories")
public class PfaApplication {
	public static void main(String[] args) {
		SpringApplication.run(PfaApplication.class, args);
	}

}
