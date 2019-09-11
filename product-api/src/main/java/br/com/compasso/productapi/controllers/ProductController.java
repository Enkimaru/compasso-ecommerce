package br.com.compasso.productapi.controllers;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.compasso.productapi.models.Product;
import br.com.compasso.productapi.models.dtos.ProductDTO;
import br.com.compasso.productapi.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public ProductService productService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Product> getProduct(@PageableDefault(page=0, size=5) Pageable pageable, 
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category) {
		return productService.getProduct(pageable, brand, category);
	}
	
	@GetMapping (params = "name")
	public Product getProductByName(String name) {
		Optional<Product> product = productService.getProductByName(name);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Product getProductById(@PathVariable("id") Long id) {
		Optional<Product> product = productService.getProductById(id);
		
		if (product.isPresent()) {
			return product.get();
		}
		
		return null;
	}

	@PostMapping(path = "/createProduct", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Product createProduct(@RequestBody ProductDTO productDTO) {
		return productService.createProduct(productDTO);		
	}
	
	@PutMapping(path = "/updateProduct", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	@DeleteMapping(path = "/deleteProduct", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void deleteProduct(@RequestBody Product product) {
		productService.deleteProduct(product);
	}
	
}