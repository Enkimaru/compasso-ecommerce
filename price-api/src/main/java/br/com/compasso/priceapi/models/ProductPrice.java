package br.com.compasso.priceapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@Entity
@Table(name = "product")
@NoArgsConstructor
public class ProductPrice {
	
	@Id
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@NotNull
	private Double price;
	
	@NotNull
	@Column(name = "sale_price")
	private Double salePrice;

}
