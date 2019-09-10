package br.com.compasso.ecommercemodule.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.compasso.ecommercemodule.models.Category;

//@FeignClient(value = "product-api")
@FeignClient(url = "http://localhost:8091", name = "category")
public interface CategoryClient {
	
    @GetMapping(value = "/category")
    public List<Category> getAllCategory(@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "size", required = false) String size);

    @GetMapping(value = "/category")
    public Category getCategoryByName(@RequestParam String name);

    @GetMapping(value = "/category/{id}")
	public Category getCategoryById(@PathVariable Long id);

    @PostMapping(value = "/category/createCategory")
	public Category createCategory(Category category);

    @PutMapping(value = "/category/updateCategory")
	public Category updateCategory(Category category);

    @DeleteMapping(value = "/category/deleteCategory")
	public void deleteCategory(Category category);
    
}