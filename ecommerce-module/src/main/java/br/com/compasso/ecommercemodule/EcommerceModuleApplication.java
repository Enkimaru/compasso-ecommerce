package br.com.compasso.ecommercemodule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import br.com.compasso.ecommercemodule.clients.ProductClient;

@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
public class EcommerceModuleApplication {
	
	@Autowired
	private ProductClient productClient;
	
	public static void main(String[] args) {
		SpringApplication.run(EcommerceModuleApplication.class, args);
	}
}
