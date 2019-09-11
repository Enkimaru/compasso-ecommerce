package br.com.compasso.ecommercemodule.configs;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.compasso.ecommercemodule.models.Sku;
import br.com.compasso.ecommercemodule.models.dtos.SkuDTO;

@Configuration
public class AppConfig {

   @Bean
   public ModelMapper modelMapper() {
      ModelMapper modelMapper = new ModelMapper();
      modelMapper.getConfiguration().setSkipNullEnabled(true).setMatchingStrategy(MatchingStrategies.STRICT);
      modelMapper.addMappings(skuMap);
      return modelMapper;
   }
   
   private PropertyMap<SkuDTO, Sku> skuMap = new PropertyMap<SkuDTO, Sku>() {
	   protected void configure() {
	     map().getProduct().setId(source.getProductId());
	   }
	 };

	 
}
