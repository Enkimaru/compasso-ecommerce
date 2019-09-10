//package br.com.compasso.ecommercemodule.service;
//
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.compasso.productapi.models.Category;
//import br.com.compasso.productapi.repository.CategoryRepository;
//
//@Service
//public class CategoryService {
//
//	@Autowired
//	public CategoryRepository categoryRepository;
//
//	public Page<Category> getAllCategory(@PageableDefault(page=0, size=5) Pageable pageable) {
//		return categoryRepository.findAll(pageable);
//	}
//	
//	public Optional<Category> getCategoryById(@PathVariable("id") Long id) {
//		return categoryRepository.findById(id);
//	}
//	
//	public Optional<Category> getCategoryByName(@PathVariable("name") String name) {
//		return categoryRepository.findByNameIgnoreCase(name);
//	}
//
//	public Category createCategory(@RequestBody Category category) {
//		return categoryRepository.save(category);		
//	}
//	
//	public Category updateCategory(Category category) {
//		if (categoryRepository.findById(category.getId()).isPresent()){
//			return categoryRepository.save(category);
//		}
//		return null;
//	}
//
//	public void deleteCategory(Category category) {
//		if (categoryRepository.findById(category.getId()).isPresent()){
//			categoryRepository.delete(category);
//		}
//	}
//	
//}