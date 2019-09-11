package br.com.compasso.ecommercemodule.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class ProductPrice {
	
	private Long id;
	
	private Double price;
	
	private Double salePrice;

}
