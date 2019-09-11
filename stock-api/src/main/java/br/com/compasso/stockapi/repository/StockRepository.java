package br.com.compasso.stockapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.stockapi.models.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long> {
		
}