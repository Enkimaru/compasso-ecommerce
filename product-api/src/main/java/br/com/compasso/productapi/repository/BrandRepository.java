package br.com.compasso.productapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.compasso.productapi.models.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
	
	Optional<Brand> findByNameIgnoreCase(@Param("name") String name);
	
}