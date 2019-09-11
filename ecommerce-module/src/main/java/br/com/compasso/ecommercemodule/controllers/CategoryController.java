package br.com.compasso.ecommercemodule.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.compasso.ecommercemodule.models.Category;
import br.com.compasso.ecommercemodule.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	public CategoryService categoryService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Category>> getAllCategory(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size) {
		return new ResponseEntity<>(categoryService.getAllCategory(page, size), HttpStatus.OK);
	}
	
	@GetMapping(params = "name")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Category> getCategoryByName(String name) {
		return new ResponseEntity<>(categoryService.getCategoryByName(name), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Category> getCategoryById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(categoryService.getCategoryById(id), HttpStatus.OK);
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