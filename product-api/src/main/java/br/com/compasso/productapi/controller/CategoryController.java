package br.com.compasso.productapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.productapi.models.Category;
import br.com.compasso.productapi.repository.CategoryRepository;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	public CategoryRepository categoryRepository;

	@GetMapping("")
	@ResponseBody
	public Page<Category> getAllCategory(@PageableDefault(page=0, size=5) Pageable paginacao) {
		return categoryRepository.findAll(paginacao);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable("id") Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		
		if (category.isPresent()) {
			return ResponseEntity.ok(category);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping(path = "/createCategory", consumes = "application/json", produces = "application/json")
	public void createCategory(@RequestBody Category category) {
		categoryRepository.save(category);		
	}
	
	@PutMapping(path = "/updateCategory", consumes = "application/json", produces = "application/json")
	public void updateCategory(@RequestBody Category category) {
		if (category.getId() != null) {
			categoryRepository.save(category);
		}
	}
	
}