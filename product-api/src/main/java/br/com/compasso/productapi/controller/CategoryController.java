package br.com.compasso.productapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import org.springframework.http.HttpStatus;

import br.com.compasso.productapi.models.Category;
import br.com.compasso.productapi.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	public CategoryService categoryService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Category> getAllCategory(@PageableDefault(page=0, size=5) Pageable pageable) {
		return categoryService.getAllCategory(pageable);
	}
	
	@GetMapping (params = "name")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Category> getCategoryByName(String name) {
		Optional<Category> category = categoryService.getCategoryByName(name);
		if (category.isPresent()) {
			return new ResponseEntity<>(category.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
		Optional<Category> category = categoryService.getCategoryById(id);
		
		if (category.isPresent()) {
			return new ResponseEntity<>(category.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	
	@PostMapping(path = "/createCategory", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Category> createCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.OK);		
	}
	
	@PutMapping(path = "/updateCategory", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.updateCategory(category), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/deleteCategory", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Category> deleteCategory(@RequestBody Category category) {
		categoryService.deleteCategory(category);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}