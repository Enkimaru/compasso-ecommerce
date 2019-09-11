package br.com.compasso.ecommercemodule.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.compasso.ecommercemodule.clients.CategoryClient;
import br.com.compasso.ecommercemodule.models.Category;

@Service
public class CategoryService {
	
	@Autowired
	public CategoryClient categoryClient;
	
	public List<Category> getAllCategory(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size
			) {
		return categoryClient.getAllCategory(page, size);
	}
	
	public Category getCategoryById(Long id) {
		return categoryClient.getCategoryById(id);
	}

	public Category getCategoryByName(String name) {
		return categoryClient.getCategoryByName(name);
	}
 
	public Category createCategory(Category category) {
		return categoryClient.createCategory(category);		
	}
	
	public Category updateCategory(Category category) {
		return categoryClient.updateCategory(category);
	}

	public void deleteCategory(Category category) {
			categoryClient.deleteCategory(category);
	}
	
}