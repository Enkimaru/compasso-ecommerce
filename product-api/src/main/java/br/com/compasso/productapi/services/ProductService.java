package br.com.compasso.productapi.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	
	@Autowired
	public ModelMapper modelMapper;

	public List<Product> getProduct(@PageableDefault(page=0, size=5) Pageable pageable) {	
		return productRepository.findAll(pageable).getContent();	
	}
	
	public Product getProductById(Long id) {
		if (productRepository.findById(id).isPresent()) {
			return productRepository.findById(id).get(); 
		} else {
            throw new EntityNotFoundException("Produto com ID:" + id.toString() + " não foi encontrado.");
		}		
	}

	public Product createProduct(ProductDTO productDTO) {
		Product product = modelMapper.map(productDTO, Product.class);
		return productRepository.save(product);		
	}
	
	public Product updateProduct(Product product) {
		if (productRepository.findById(product.getId()).isPresent()){
			return productRepository.save(product);
		} else {
            throw new EntityNotFoundException("Produto com ID:" + id.toString() + " não foi encontrado.");
		}
	}
	
	@Transactional
	public Integer deactivateProduct(Long id) {
		return productRepository.deactivateProduct(id);
	}
	
}