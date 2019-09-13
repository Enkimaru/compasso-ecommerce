package br.com.compasso.productapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

	@PostMapping
	public ResponseEntity<Void> createProduct(@RequestBody ProductDTO productDTO) {
		productService.createProduct(productDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateProduct(@PathVariable("id") Long id,
			@RequestBody ProductDTO productDTO) {
		productService.updateProduct(id, productDTO);
		return ResponseEntity.ok().build();
	}
	
	@PatchMapping("/deactivate/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
		productService.deactivateProduct(id);
		return ResponseEntity.ok().build();
	}
	
	
}