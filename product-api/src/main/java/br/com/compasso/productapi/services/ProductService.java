package br.com.compasso.productapi.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.compasso.productapi.models.Product;
import br.com.compasso.productapi.models.dtos.ProductDTO;
import br.com.compasso.productapi.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	public ProductRepository productRepository;
	
	@Autowired
	public ModelMapper modelMapper;

	public List<Product> getProduct(Pageable pageable) {	
		return productRepository.findAll(pageable).getContent();	
	}
	
	public Product getProductById(Long id) {
		if (productRepository.findById(id).isPresent()) {
			return productRepository.findById(id).get(); 
		} else {
            throw new EntityNotFoundException("Produto com ID:" + id.toString() + " não foi encontrado.");
		}		
	}

	public void createProduct(ProductDTO productDTO) {
			Product product = modelMapper.map(productDTO, Product.class);
			productRepository.save(product);	
	}
	
	public void updateProduct(Long id, ProductDTO productDTO) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()){
			Product dbProduct = optionalProduct.get();
			Product product = modelMapper.map(productDTO, Product.class);
			
			modelMapper.map(product, dbProduct);
			productRepository.save(dbProduct);
		} else {
            throw new EntityNotFoundException("Produto com ID:" + id.toString() + " não foi encontrado.");
		}
	}
	
	@Transactional
	public Integer deactivateProduct(Long id) {
		return productRepository.deactivateProduct(id);
	}
	
}