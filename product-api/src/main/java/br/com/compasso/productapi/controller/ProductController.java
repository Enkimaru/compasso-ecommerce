package br.com.compasso.productapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.productapi.models.Product;
import br.com.compasso.productapi.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public ProductRepository productRepository;

	@GetMapping("")
	@ResponseBody
	public Page<Product> getAllProduct(@PageableDefault(page=0, size=5) Pageable paginacao) {
		return productRepository.findAll(paginacao);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") Long id) {
		Optional<Product> product = productRepository.findById(id);
		
		if (product.isPresent()) {
			return ResponseEntity.ok(product);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping(path = "/createProduct", consumes = "application/json", produces = "application/json")
	public void createProduct(@RequestBody Product product) {
		productRepository.save(product);		
	}
	
	@PutMapping(path = "/updateProduct", consumes = "application/json", produces = "application/json")
	public void updateProduct(@RequestBody Product product) {
		if (product.getId() != null) {
			productRepository.save(product);
		}
	}
	
}