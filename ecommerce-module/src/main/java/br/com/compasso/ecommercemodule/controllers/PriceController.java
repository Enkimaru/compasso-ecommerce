package br.com.compasso.ecommercemodule.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.ecommercemodule.models.ProductPrice;
import br.com.compasso.ecommercemodule.models.SkuPrice;
import br.com.compasso.ecommercemodule.services.PriceService;

@RestController
@RequestMapping("/price")
public class PriceController {

	@Autowired
	public PriceService priceService;


	@PutMapping(path = "/updateProductPrice", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<ProductPrice> updateProductPrice(@RequestBody ProductPrice productPrice) {
		return new ResponseEntity<>(priceService.updateProductPrice(productPrice), HttpStatus.OK);
	}
	
	@PutMapping(path = "/updateSkuPrice", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<SkuPrice> updateSkuPrice(@RequestBody SkuPrice skuPrice) {
		return new ResponseEntity<>(priceService.updateSkuPrice(skuPrice), HttpStatus.OK);
	}
	
}