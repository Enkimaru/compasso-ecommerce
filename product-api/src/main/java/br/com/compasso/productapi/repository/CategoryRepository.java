package br.com.compasso.productapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.compasso.productapi.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}