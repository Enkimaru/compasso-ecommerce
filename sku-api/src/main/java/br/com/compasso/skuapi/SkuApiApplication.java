package br.com.compasso.skuapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SkuApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SkuApiApplication.class, args);
	}

}
