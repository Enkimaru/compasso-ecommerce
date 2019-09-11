package br.com.compasso.productstatusapi.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compasso.productstatusapi.models.Product;

@Repository
public interface ProductStatusRepository extends JpaRepository<Product, Long> {
	
	@Modifying
	@Query("update product p set p.enabled = false where p.id = :id")
	Integer deactivateProduct(@Param("id") Long id);
	
	@Modifying
	@Query("update product p set p.enabled = true where p.id = :id")
	Integer activateProduct(@Param("id") Long id);
}