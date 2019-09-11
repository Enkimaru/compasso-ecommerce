package br.com.compasso.priceapi.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.priceapi.models.ProductPrice;
import br.com.compasso.priceapi.repositories.ProductPriceRepository;

@Service
public class ProductPriceService {

	@Autowired
	public ProductPriceRepository productPriceRepository;
	
	@Autowired
	public ModelMapper modelMapper;
	
	public ProductPrice updateProductPrice(ProductPrice productPrice) {
		
		Optional<ProductPrice> oldProductPrice = productPriceRepository.findById(productPrice.getId());
		
		if (oldProductPrice.isPresent()){		      
		    ProductPrice newProductPrice = oldProductPrice.get();
		    modelMapper.map(productPrice, newProductPrice);
		      
			return productPriceRepository.save(newProductPrice);
		}
		return null;
	}
	
}