package br.com.compasso.productapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import br.com.compasso.productapi.models.Product;
import br.com.compasso.productapi.models.dtos.ProductDTO;
import br.com.compasso.productapi.services.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public ProductService productService;

	@GetMapping
	public ResponseEntity<List<Product>> getProduct(@PageableDefault(page=0, size=5) Pageable pageable) {
		return ResponseEntity.ok(productService.getProduct(pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(productService.getProductById(id));
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Long createProduct(@RequestBody ProductDTO productDTO) {
		return productService.createProduct(productDTO).getId();		
	}
	
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
//	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
//		productService.deleteProduct(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	
}