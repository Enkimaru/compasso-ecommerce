package br.com.compasso.productapi.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class ProductDTO {
	private String description;
	private String name;
	private Double price;
	private Double salePrice;
	private Long brandId;
	private Long categoryId;	
}
