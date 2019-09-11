package br.com.compasso.skustatusapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.compasso.skustatusapi.models.Sku;
import br.com.compasso.skustatusapi.repositories.SkuStatusRepository;

@Service
public class SkuStatusService {

	@Autowired
	public SkuStatusRepository skuStatusRepository;
	
	
	public boolean isValid (@PathVariable("id") Long id) {
		Optional<Sku> optionalSku = skuStatusRepository.findById(id);
		if (optionalSku.isPresent()){
			Sku sku = optionalSku.get();
			
			if (sku.getPrice() <= 0 || sku.getPrice() == null || sku.getStock() <= 0) {
				return false;
			} 
			return true;
		}
		return false;
	}
	
	@Transactional
	public Integer deactivateSku(Long id) {
		return skuStatusRepository.deactivateSku(id);
	}
	
	@Transactional
	public Integer activateSku(Long id) {
		if (isValid(id)) {
			return skuStatusRepository.activateSku(id);
		}
			return null;
	}
	
}