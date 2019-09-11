package br.com.compasso.ecommercemodule.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.compasso.ecommercemodule.client.ProductClient;
import br.com.compasso.ecommercemodule.models.Product;
import br.com.compasso.ecommercemodule.models.dto.ProductDTO;

@Service
public class ProductService {
	
	@Autowired
	public ProductClient productClient;
	
	public List<Product> getProduct(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category
			) {
			return productClient.getProduct(page, size, brand, category);
	}
	
	public Product getProductById(Long id) {
		return productClient.getProductById(id);
	}

	public Product getProductByName(String name) {
		return productClient.getProductByName(name);
	}
 
	public Product createProduct(Product product) {
		
		ModelMapper modelMapper = new ModelMapper();
		ProductDTO dto = modelMapper.map(product, ProductDTO.class);
		
		return productClient.createProduct(dto);		
	}
	
	public Product updateProduct(Product product) {
		return productClient.updateProduct(product);
	}

	public void deleteProduct(Product product) {
			productClient.deleteProduct(product);
	}
	
}