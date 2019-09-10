package br.com.compasso.productapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

@Service
public class ProductService {

	@Autowired
	public ProductRepository productRepository;

	public Page<Product> getAllProduct(@PageableDefault(page=0, size=5) Pageable pageable) {
		return productRepository.findAll(pageable);
	}
	
	public Optional<Product> getProductById(@PathVariable("id") Long id) {
		return productRepository.findById(id);
	}

	public Product createProduct(@RequestBody Product product) {
		return productRepository.save(product);		
	}
	
	public Product updateProduct(Product product) {
		if (productRepository.findById(product.getId()).isPresent()){
			return productRepository.save(product);
		}
		return null;
	}
	
}