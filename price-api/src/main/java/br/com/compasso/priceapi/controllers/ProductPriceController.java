package br.com.compasso.priceapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.priceapi.models.ProductPrice;
import br.com.compasso.priceapi.services.ProductPriceService;

@RestController
@RequestMapping("/price")
public class ProductPriceController {

	@Autowired
	public ProductPriceService productPriceService;

	@PutMapping(path = "/updateProductPrice", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ProductPrice updateProductPrice(@RequestBody ProductPrice productPrice) {
		return productPriceService.updateProductPrice(productPrice);
	}
	
}