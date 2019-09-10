package br.com.compasso.productapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.compasso.productapi.models.Brand;
import br.com.compasso.productapi.models.Product;
import br.com.compasso.productapi.repository.ProductRepository;
import br.com.compasso.productapi.service.BrandService;
import br.com.compasso.productapi.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public ProductService productService;
	
	@Autowired
	public BrandService brandService;

	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public Page<Product> getAllProduct(@PageableDefault(page=0, size=10) Pageable pageable) {
		return productService.getAllProduct(pageable);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
		Optional<Product> product = productService.getProductById(id);
		
		if (product.isPresent()) {
			return new ResponseEntity<>(product.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
	
//	@DeleteMapping(path = "/deleteProduct", consumes = "application/json", produces = "application/json")
//	@ResponseStatus(HttpStatus.OK)
//	public ResponseEntity<Product> deleteProduct(@RequestBody Product product) {
//		productService.deleteProduct(product);
//		return new ResponseEntity<>(HttpStatus.OK);
//	}
	
}