package br.com.compasso.priceapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.priceapi.models.SkuPrice;
import br.com.compasso.priceapi.services.SkuPriceService;

@RestController
@RequestMapping("/price")
public class SkuPriceController {

	@Autowired
	public SkuPriceService skuPriceService;

	@PutMapping(path = "/updateSkuPrice", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public SkuPrice updateSkuPrice(@RequestBody SkuPrice skuPrice) {
		return skuPriceService.updateSkuPrice(skuPrice);
	}
	
}