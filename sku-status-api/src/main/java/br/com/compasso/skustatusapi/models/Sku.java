package br.com.compasso.skustatusapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Entity(name = "sku")
@NoArgsConstructor
public class Sku {
	
	@Id
    @GeneratedValue(generator = "sku_generator")
    @SequenceGenerator(
            name = "sku_generator",
            sequenceName = "sku_generator",
            initialValue = 1
    )
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 1, max = 20)
	private String name;
	
	private String description;
	
	@NotNull
	private int stock;
	
	@NotNull
	private Double price;
	
	@NotNull
	private boolean enabled;

	@ManyToOne
	@JoinColumn(name = "product_id")
	@JsonIgnore
	private Product product;

}
