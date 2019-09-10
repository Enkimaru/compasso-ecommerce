package br.com.compasso.ecommercemodule.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class Product {
	private Long id;
	
	private String description;
	
	private String name;
	
	private double price;
	
	private double salePrice;
	
	private boolean enabled;
	
	private Brand brand;
	
	private Category category;
	
	private List<Sku> skus;
	
}
