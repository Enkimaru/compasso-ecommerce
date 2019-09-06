package br.com.compasso.deactivationproductapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeactivationProductApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeactivationProductApiApplication.class, args);
	}

}
