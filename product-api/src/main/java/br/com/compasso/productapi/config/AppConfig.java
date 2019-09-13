package br.com.compasso.productapi.config;

import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.compasso.productapi.models.Product;
import br.com.compasso.productapi.models.dtos.ProductDTO;

@Configuration
public class AppConfig {

   @Bean
   public ModelMapper modelMapper() {
      ModelMapper modelMapper = new ModelMapper();
      modelMapper.getConfiguration()
      			 .setSkipNullEnabled(true)
      			 .setMatchingStrategy(MatchingStrategies.STRICT)
      			 .setPropertyCondition(Conditions.isNotNull());

      modelMapper.addMappings(productMap);
      
      return modelMapper;
   }
	 
	private PropertyMap<ProductDTO, Product> productMap = new PropertyMap<ProductDTO, Product>() {
	   protected void configure() {
		   map().getBrand().setId(source.getBrandId());
		   map().getCategory().setId(source.getCategoryId());
	   }
	};
}
