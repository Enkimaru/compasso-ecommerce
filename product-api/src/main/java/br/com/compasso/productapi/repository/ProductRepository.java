package br.com.compasso.productapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compasso.productapi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findByNameIgnoreCase(@Param("name") String name);
	
}