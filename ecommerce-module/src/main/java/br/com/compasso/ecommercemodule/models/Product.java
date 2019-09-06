package br.com.compasso.ecommercemodule.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class Product {

	private Integer id;
	private String description;
	private boolean enabled;
	
}
