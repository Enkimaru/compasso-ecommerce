package br.com.compasso.priceapi;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableEurekaClient
public class PriceApiApplication {
	
	@Autowired
	ModelMapper modelMapper = new ModelMapper();
	
	public static void main(String[] args) {
		SpringApplication.run(PriceApiApplication.class, args);
	}

}
