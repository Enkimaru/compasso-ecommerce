package br.com.compasso.priceapi.services;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.priceapi.models.SkuPrice;
import br.com.compasso.priceapi.repositories.SkuPriceRepository;

@Service
public class SkuPriceService {

	@Autowired
	public SkuPriceRepository skuPriceRepository;
	
	@Autowired
	public ModelMapper modelMapper;
	
	public SkuPrice updateSkuPrice(SkuPrice skuPrice) {
		
		Optional<SkuPrice> oldSkuPrice = skuPriceRepository.findById(skuPrice.getId());
		
		if (oldSkuPrice.isPresent()){		      
		    SkuPrice newSkuPrice = oldSkuPrice.get();
		    modelMapper.map(skuPrice, newSkuPrice);
		      
			return skuPriceRepository.save(newSkuPrice);
		}
		return null;
	}
	
}