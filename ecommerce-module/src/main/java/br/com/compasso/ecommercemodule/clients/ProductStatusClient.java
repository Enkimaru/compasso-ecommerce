package br.com.compasso.ecommercemodule.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(value = "product-api")
@FeignClient(url = "http://localhost:8094", name = "product-status")
public interface ProductStatusClient {
	

    @DeleteMapping(value = "/productStatus/deactivateProduct/{id}")
	public void deleteProduct(@PathVariable("id") Long id);
    
}