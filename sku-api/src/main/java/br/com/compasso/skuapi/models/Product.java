package br.com.compasso.skuapi.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter 
@Entity(name = "product")
@NoArgsConstructor
public class Product {

	@Id
    @GeneratedValue(generator = "product_generator")
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_generator",
            initialValue = 1
    )
	@Column(updatable = false, nullable = false)
	private Long id;
	
	private String description;
	
	@NotBlank
	@Size(min = 1, max = 20)
	private String name;
	
	@NotNull
	private double price;
	
	@NotNull
	private double salePrice;
	
	@NotNull
	private boolean enabled;
	
	@OneToMany
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private List<Sku> skus;
	
}
