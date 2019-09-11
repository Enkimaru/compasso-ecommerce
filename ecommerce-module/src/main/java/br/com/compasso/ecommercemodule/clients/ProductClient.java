package br.com.compasso.ecommercemodule.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.compasso.ecommercemodule.models.Product;
import br.com.compasso.ecommercemodule.models.dtos.ProductDTO;

//@FeignClient(value = "product-api")
@FeignClient(url = "http://localhost:8091", name = "product")
public interface ProductClient {
	
    @GetMapping(value = "/product")
    public List<Product> getProduct(@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category);

    @GetMapping(value = "/product")
    public Product getProductByName(@RequestParam String name);

    @GetMapping(value = "/product/{id}")
	public Product getProductById(@PathVariable Long id);

    @PostMapping(value = "/product/createProduct")
	public Product createProduct(ProductDTO productDTO);

    @PutMapping(value = "/product/updateProduct")
	public Product updateProduct(Product product);
    
}