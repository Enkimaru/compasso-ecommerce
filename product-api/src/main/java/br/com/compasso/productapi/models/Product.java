package br.com.compasso.productapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "product")
@Data
public class Product {

	@Id
    @GeneratedValue(generator = "product_generator")
    @SequenceGenerator(
            name = "product_generator",
            sequenceName = "product_sequence",
            initialValue = 1
    )
    @Column(updatable = false, nullable = false)
	private Long id;
	
	@NotBlank
	private String description;
	
	private boolean enabled;
}
