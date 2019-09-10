package br.com.compasso.ecommercemodule.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class Sku {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private int stock;
	
	private double price;
	
	private boolean enabled;

	private Product product;

}
