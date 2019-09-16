package br.com.compasso.productapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.productapi.models.Category;
import br.com.compasso.productapi.models.dtos.CategoryDTO;
import br.com.compasso.productapi.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	public CategoryService categoryService;

	@GetMapping
	public ResponseEntity<List<Category>> getCategory(@PageableDefault(page=0, size=5) Pageable pageable) {
		return ResponseEntity.ok(categoryService.getCategory(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(categoryService.getCategoryById(id));
	}

	@PostMapping
	public ResponseEntity<Void> createCategory(@RequestBody CategoryDTO categoryDTO) {
		categoryService.createCategory(categoryDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();		
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateCategory(@PathVariable("id") Long id,
			@RequestBody CategoryDTO categoryDTO) {
			categoryService.updateCategory(id, categoryDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategory(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);
		return ResponseEntity.noContent().build();
	}
	
}