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
@Entity(name = "brand")
@NoArgsConstructor
public class Brand {

	@Id
    @GeneratedValue(generator = "brand_generator")
    @SequenceGenerator(
            name = "brand_generator",
            sequenceName = "brand_sequence",
            initialValue = 1
    )
    @Column(updatable = false, nullable = false)
	private Long id;

	@NotBlank
	@Size(min = 1, max = 20)
	private String name;	

}
