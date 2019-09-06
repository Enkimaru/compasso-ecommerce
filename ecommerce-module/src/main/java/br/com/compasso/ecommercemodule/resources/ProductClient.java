package br.com.compasso.ecommercemodule.resources;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.compasso.ecommercemodule.models.Product;

@FeignClient(value = "product-api")
public interface ProductClient {
	
    @RequestMapping(method = RequestMethod.GET, value = "/product/{userId}")
    public Product getCatalog(@PathVariable("userId") Integer userId);
    
}