package br.com.compasso.ecommercemodule.models.dto;

import br.com.compasso.ecommercemodule.models.Brand;
import br.com.compasso.ecommercemodule.models.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class ProductDTO {	
	private String description;
	
	private String name;
	
	private double price;
	
	private double salePrice;
		
	private Brand brand;
	
	private Category category;	
}
