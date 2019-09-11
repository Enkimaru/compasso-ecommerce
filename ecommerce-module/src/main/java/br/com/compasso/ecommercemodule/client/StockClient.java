package br.com.compasso.ecommercemodule.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.compasso.ecommercemodule.models.Stock;

//@FeignClient(value = "stock-api")
@FeignClient(url = "http://localhost:8095", name = "stock")
public interface StockClient {
	
    @PutMapping(value = "/stock/updateStock")
	public Stock updateStock(Stock stock);
    
}