package br.com.compasso.stockapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.stockapi.models.Stock;
import br.com.compasso.stockapi.services.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	public StockService stockService;

	@PutMapping(path = "/updateStock", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Stock updateStock(@RequestBody Stock stock) {
		return stockService.updateStock(stock);
	}
	
}