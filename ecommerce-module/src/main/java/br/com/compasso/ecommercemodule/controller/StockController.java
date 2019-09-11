package br.com.compasso.ecommercemodule.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.compasso.ecommercemodule.models.Stock;
import br.com.compasso.ecommercemodule.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	public StockService stockService;


	@PutMapping(path = "/updateStock", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Stock> updateStock(@RequestBody Stock stock) {
		return new ResponseEntity<>(stockService.updateStock(stock), HttpStatus.OK);
	}
	
}