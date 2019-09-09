package br.com.compasso.productapi.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@Entity(name = "category")
@NoArgsConstructor
public class Category {
	
	@Id
    @GeneratedValue(generator = "category_generator")
    @SequenceGenerator(
            name = "category_generator",
            sequenceName = "category_generator",
            initialValue = 1
    )
	@Column(updatable = false, nullable = false)
	private Long id;
	
	@NotBlank
	@Size(min = 1, max = 20)
	private String name;

}
