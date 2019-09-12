package br.com.compasso.productapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compasso.productapi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Modifying
	@Query("update product p set p.enabled = false where p.id = :id")
	Integer deactivateProduct(@Param("id") Long id);
	
}