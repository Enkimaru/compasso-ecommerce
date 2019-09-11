package br.com.compasso.ecommercemodule.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import br.com.compasso.ecommercemodule.models.Product;
import br.com.compasso.ecommercemodule.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public ProductService productService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Product>> getProduct(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category) {
		return new ResponseEntity<>(productService.getProduct(page, size, brand, category), HttpStatus.OK);
	}
	
	@GetMapping("/enabled")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Product>> getProductEnabled(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category) {
		return new ResponseEntity<>(productService.getProductEnabled(page, size, brand, category), HttpStatus.OK);
	}
	
	@GetMapping(params = "name")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> getProductByName(String name) {
		return new ResponseEntity<>(productService.getProductByName(name), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
	}

	@PostMapping(path = "/createProduct", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.createProduct(product), HttpStatus.OK);		
	}
	
	@PutMapping(path = "/updateProduct", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/deleteProduct/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path = "/activateProduct/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> activateProduct(@PathVariable("id") Long id) {
		productService.activateProduct(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}