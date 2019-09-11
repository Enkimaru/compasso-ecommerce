package br.com.compasso.stockapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compasso.stockapi.models.Stock;
import br.com.compasso.stockapi.repositories.StockRepository;

@Service
public class StockService {

	@Autowired
	public StockRepository stockRepository;
	
	public Stock updateStock(Stock stock) {
		if (stockRepository.findById(stock.getId()).isPresent()){
			return stockRepository.save(stock);
		}
		return null;
	}
	
}