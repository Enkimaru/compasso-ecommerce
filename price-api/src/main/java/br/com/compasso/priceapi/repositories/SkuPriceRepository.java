package br.com.compasso.priceapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.priceapi.models.SkuPrice;

@Repository
public interface SkuPriceRepository extends JpaRepository<SkuPrice, Long> {
		
}