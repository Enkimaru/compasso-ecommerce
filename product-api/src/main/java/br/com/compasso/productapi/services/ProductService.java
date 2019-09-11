package br.com.compasso.productapi.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.compasso.productapi.models.Product;
import br.com.compasso.productapi.models.dtos.ProductDTO;
import br.com.compasso.productapi.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	public ProductRepository productRepository;

	public List<Product> getProduct(@PageableDefault(page=0, size=5) Pageable pageable,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category) {
		
		if (brand != null) {
			if (category != null) {
				return productRepository.findByBrandNameAndCategoryNameIgnoreCase(brand, category);
			} else {
				return productRepository.findByBrandNameIgnoreCase(brand);
			}
		} else if (category != null) {
			return productRepository.findByCategoryNameIgnoreCase(category);
		}
		
		return productRepository.findAll(pageable).getContent();
		
	}
	
	public Optional<Product> getProductById(@PathVariable("id") Long id) {
		return productRepository.findById(id);
	}
	
	public Optional<Product> getProductByName(@PathVariable("name") String name) {
		return productRepository.findByNameIgnoreCase(name);
	}

	public Product createProduct(@RequestBody ProductDTO productDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Product product = modelMapper.map(productDTO, Product.class);
		return productRepository.save(product);		
	}
	
	public Product updateProduct(Product product) {
		if (productRepository.findById(product.getId()).isPresent()){
			return productRepository.save(product);
		}
		return null;
	}

	public void deleteProduct(Product product) {
		///usar a API de controle de status de produto
//		if (productRepository.findById(product.getId()).isPresent()){
//			productRepository.delete(product);
//		}
	}
	
}