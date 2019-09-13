package br.com.compasso.productapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO) {
		productService.createProduct(productDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();		
	}
	
	@PutMapping(value= "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id,
			@RequestBody ProductDTO productDTO) {
		return ResponseEntity.ok(productService.updateProduct(id, productDTO));
	}
	
//	@DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<Product> deleteProduct(@PathVariable("id") Long id) {
//		productService.deleteProduct(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
	
}