package br.com.compasso.productapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.compasso.productapi.models.Category;
import br.com.compasso.productapi.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	public CategoryRepository categoryRepository;

	public List<Category> getAllCategory(@PageableDefault(page=0, size=5) Pageable pageable) {
		return categoryRepository.findAll(pageable).getContent();
	}
	
	public Optional<Category> getCategoryById(@PathVariable("id") Long id) {
		return categoryRepository.findById(id);
	}
	
	public Optional<Category> getCategoryByName(@PathVariable("name") String name) {
		return categoryRepository.findByNameIgnoreCase(name);
	}

	public Category createCategory(@RequestBody Category category) {
		return categoryRepository.save(category);		
	}
	
	public Category updateCategory(Category category) {
		if (categoryRepository.findById(category.getId()).isPresent()){
			return categoryRepository.save(category);
		}
		return null;
	}

	public void deleteCategory(Category category) {
		if (categoryRepository.findById(category.getId()).isPresent()){
			categoryRepository.delete(category);
		}
	}
	
}