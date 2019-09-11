package br.com.compasso.skuapi.models.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@NoArgsConstructor
public class SkuDTO {
	private String description;
	private String name;
	private Double price;
	private Integer stock;
	private Long productId;
}
