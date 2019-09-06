package br.com.compasso.deactivationskuapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DeactivationSkuApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeactivationSkuApiApplication.class, args);
	}

}
