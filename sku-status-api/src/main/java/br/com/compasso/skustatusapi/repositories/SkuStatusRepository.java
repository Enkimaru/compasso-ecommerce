package br.com.compasso.skustatusapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compasso.skustatusapi.models.Sku;

@Repository
public interface SkuStatusRepository extends JpaRepository<Sku, Long> {
	
	@Modifying
	@Query("update sku p set p.enabled = false where p.id = :id")
	Integer deactivateSku(@Param("id") Long id);
	
	@Modifying
	@Query("update sku p set p.enabled = true where p.id = :id")
	Integer activateSku(@Param("id") Long id);
}