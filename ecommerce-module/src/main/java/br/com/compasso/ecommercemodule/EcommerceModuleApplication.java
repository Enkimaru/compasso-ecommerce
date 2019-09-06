package br.com.compasso.ecommercemodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import br.com.compasso.ecommercemodule.models.Product;
import br.com.compasso.ecommercemodule.resources.ProductClient;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class EcommerceModuleApplication {
	
	@Autowired
	private ProductClient productClient;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceModuleApplication.class, args);
	}
}
