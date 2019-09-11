package br.com.compasso.productstatusapi.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.productstatusapi.models.Product;
import br.com.compasso.productstatusapi.services.ProductStatusService;

@RestController
@RequestMapping("/productStatus")
public class ProductStatusController {

	@Autowired
	public ProductStatusService productStatusService;
	
	@DeleteMapping("/deactivateProduct/{id}")
	public Integer deactivateProduct(@PathVariable("id") Long id) {
		return productStatusService.deactivateProduct(id);
	}

	@GetMapping (params = "name")
	public Product getProductByName(String name) {
		Optional<Product> product = productStatusService.getProductByName(name);
		if (product.isPresent()) {
			return product.get();
		}
		return null;
	}
//	@PutMapping(path = "/updateProductStatus", consumes = "application/json", produces = "application/json")
//	@ResponseStatus(HttpStatus.OK)
//	public ProductStatus updateProductStatus(@RequestBody ProductStatus productStatus) {
//		return productStatusService.updateProductStatus(productStatus);
//	}
	
}