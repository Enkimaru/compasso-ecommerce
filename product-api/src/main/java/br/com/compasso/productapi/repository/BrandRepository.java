package br.com.compasso.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.compasso.productapi.models.Brand;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

	@Query("FROM brand WHERE name = ?1")
	Brand findByName(String name);

}