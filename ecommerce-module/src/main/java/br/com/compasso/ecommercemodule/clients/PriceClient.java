package br.com.compasso.ecommercemodule.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.compasso.ecommercemodule.models.ProductPrice;
import br.com.compasso.ecommercemodule.models.SkuPrice;

//@FeignClient(value = "price-api")
@FeignClient(url = "http://localhost:8096", name = "price")
public interface PriceClient {
	
    @PutMapping(value = "/price/updateProductPrice")
	public ProductPrice updateProductPrice(ProductPrice productPrice);
    
    @PutMapping(value = "/price/updateSkuPrice")
	public SkuPrice updateSkuPrice(SkuPrice skuPrice);
    
}