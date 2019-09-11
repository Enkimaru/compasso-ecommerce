package br.com.compasso.productstatusapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.compasso.productstatusapi.models.Product;
import br.com.compasso.productstatusapi.models.Sku;
import br.com.compasso.productstatusapi.repositories.ProductStatusRepository;

@Service
public class ProductStatusService {

	@Autowired
	public ProductStatusRepository productStatusRepository;
	
	
	public boolean isValid (@PathVariable("id") Long id) {
		Optional<Product> optionalProduct = productStatusRepository.findById(id);
		if (optionalProduct.isPresent()){
			Product product = optionalProduct.get();
			
			if (product.getPrice() == 0 || product.getPrice() == null) {
				return false;
			} 
			
			for (Sku sku : product.getSkus()) {
				if (sku.getStock() > 0 && sku.isEnabled()) {
					return true;
				}
			}
		}
		return false;
	}
	
	@Transactional
	public Integer deactivateProduct(Long id) {
		return productStatusRepository.deactivateProduct(id);
	}
	public Optional<Product> getProductByName(@PathVariable("name") String name) {
		return productStatusRepository.findByNameIgnoreCase(name);
	}
//	public Stock updateStock(Stock stock) {
//		if (stockRepository.findById(stock.getId()).isPresent()){
//			return stockRepository.save(stock);
//		}
//		return null;
//	}
	
}