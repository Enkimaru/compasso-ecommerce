package br.com.compasso.productapi.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compasso.productapi.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	
	Optional<Product> findByNameIgnoreCase(@Param("name") String name);
	
	Page<Product> findByBrandNameIgnoreCase(@Param("brand") String brand, Pageable pageable);
	
	Page<Product> findByCategoryNameIgnoreCase(@Param("category") String category, Pageable pageable);
	
	Page<Product> findByBrandNameAndCategoryNameIgnoreCase(@Param("brand") String brand, 
			@Param("category") String category, 
			Pageable pageable);
	
	Page<Product> findByEnabled(@Param("enabled") Boolean enabled, Pageable pageable);
	
	Page<Product> findByEnabledAndBrandNameIgnoreCase(@Param("enabled") Boolean enabled, @Param("brand") String brand, Pageable pageable);
	
	Page<Product> findByEnabledAndCategoryNameIgnoreCase(@Param("enabled") Boolean enabled, @Param("category") String category, Pageable pageable);
	
	Page<Product> findByEnabledAndBrandNameAndCategoryNameIgnoreCase(@Param("enabled") Boolean enabled, 
			@Param("brand") String brand, 
			@Param("category") String category, 
			Pageable pageable);
	
}