package br.com.compasso.ecommercemodule.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.compasso.ecommercemodule.models.Product;

//@FeignClient(value = "product-api")
@FeignClient(url = "http://localhost:8091", name = "product")
public interface ProductClient {
	
    @RequestMapping(method = RequestMethod.GET, value = "/product/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id);
    
}