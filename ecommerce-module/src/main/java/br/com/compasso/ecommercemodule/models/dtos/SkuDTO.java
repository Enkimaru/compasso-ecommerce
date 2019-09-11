package br.com.compasso.ecommercemodule.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class SkuDTO {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private int stock;
	
	private double price;
	
	private Long productId;

}
