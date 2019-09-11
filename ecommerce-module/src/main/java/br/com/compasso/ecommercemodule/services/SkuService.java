package br.com.compasso.ecommercemodule.services;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.compasso.ecommercemodule.clients.SkuClient;
import br.com.compasso.ecommercemodule.clients.SkuStatusClient;
import br.com.compasso.ecommercemodule.models.Sku;
import br.com.compasso.ecommercemodule.models.dtos.SkuDTO;

@Service
public class SkuService {
	
	@Autowired
	public SkuClient skuClient;
	
	@Autowired
	public SkuStatusClient skuStatusClient;
	
	public List<Sku> getSku(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category
			) {
			return skuClient.getSku(page, size, brand, category);
	}
	
	public List<Sku> getSkuEnabled(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category
			) {
			return skuClient.getSkuEnabled(page, size, brand, category);
	}
	
	public Sku getSkuById(Long id) {
		return skuClient.getSkuById(id);
	}

	public Sku getSkuByName(String name) {
		return skuClient.getSkuByName(name);
	}
 
	public Sku createSku(Sku sku) {
		
		ModelMapper modelMapper = new ModelMapper();
		SkuDTO dto = modelMapper.map(sku, SkuDTO.class);
		
		return skuClient.createSku(dto);		
	}
	
	public Sku updateSku(Sku sku) {
		return skuClient.updateSku(sku);
	}
	
	public void deactivateSku(Long id) {
		skuStatusClient.deactivateSku(id);
	}
	
	public void activateSku(Long id) {
		skuStatusClient.activateSku(id);
	}
	
}