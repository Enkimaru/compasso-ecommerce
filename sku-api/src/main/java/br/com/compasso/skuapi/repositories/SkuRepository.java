package br.com.compasso.skuapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compasso.skuapi.models.Sku;

@Repository
public interface SkuRepository extends JpaRepository<Sku, Long> {
	
	Page<Sku> findByEnabled(@Param("enabled") Boolean enabled, Pageable pageable);
	
}