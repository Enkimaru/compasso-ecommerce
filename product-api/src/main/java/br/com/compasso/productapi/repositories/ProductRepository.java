package br.com.compasso.productapi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compasso.productapi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findByNameIgnoreCase(@Param("name") String name);
	
	List<Product> findByBrandNameIgnoreCase(@Param("brand") String brand);
	
	List<Product> findByCategoryNameIgnoreCase(@Param("category") String category);
	
	List<Product> findByBrandNameAndCategoryNameIgnoreCase(@Param("brand") String brand, 
			@Param("category") String category);
	
}