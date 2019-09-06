package br.com.compasso.priceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PriceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PriceApiApplication.class, args);
	}

}
