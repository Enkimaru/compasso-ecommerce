package br.com.compasso.ecommercemodule.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

//@FeignClient(value = "sku-api")
@FeignClient(url = "http://localhost:8093", name = "sku-status")
public interface SkuStatusClient {
	

    @PutMapping(value = "/skuStatus/deactivateSku/{id}")
	public void deactivateSku(@PathVariable("id") Long id);
    
    @PutMapping(value = "/skuStatus/activateSku/{id}")
	public void activateSku(@PathVariable("id") Long id);
    
}