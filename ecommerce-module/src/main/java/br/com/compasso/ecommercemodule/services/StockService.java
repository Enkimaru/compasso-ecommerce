package br.com.compasso.ecommercemodule.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.ecommercemodule.clients.StockClient;
import br.com.compasso.ecommercemodule.models.Stock;

@Service
public class StockService {
	
	@Autowired
	public StockClient stockClient;
	
	public Stock updateStock(Stock stock) {
		return stockClient.updateStock(stock);
	}
	
}