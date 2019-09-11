package br.com.compasso.productapi.models.dtos;

import br.com.compasso.productapi.models.Brand;
import br.com.compasso.productapi.models.Category;
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
