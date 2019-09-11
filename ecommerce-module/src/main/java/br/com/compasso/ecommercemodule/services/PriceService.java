package br.com.compasso.ecommercemodule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.ecommercemodule.clients.PriceClient;
import br.com.compasso.ecommercemodule.models.ProductPrice;
import br.com.compasso.ecommercemodule.models.SkuPrice;

@Service
public class PriceService {
	
	@Autowired
	public PriceClient priceClient;
	
	public ProductPrice updateProductPrice(ProductPrice productPrice) {
		return priceClient.updateProductPrice(productPrice);
	}
	
	public SkuPrice updateSkuPrice(SkuPrice skuPrice) {
		return priceClient.updateSkuPrice(skuPrice);
	}
	
}