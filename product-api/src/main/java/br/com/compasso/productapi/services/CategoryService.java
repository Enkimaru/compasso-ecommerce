package br.com.compasso.productapi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.compasso.productapi.models.Category;
import br.com.compasso.productapi.models.dtos.CategoryDTO;
import br.com.compasso.productapi.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	public CategoryRepository categoryRepository;
	
	@Autowired
	public ModelMapper modelMapper;

	public List<Category> getCategory(Pageable pageable) {
		return categoryRepository.findAll(pageable).getContent();
	}
	
	public Category getCategoryById(Long id) {
		if (categoryRepository.findById(id).isPresent()) {
			return categoryRepository.findById(id).get();
		} else {
            throw new EntityNotFoundException("Categoria com ID:" + id.toString() + " não foi encontrado.");
		}	
	}

	public void createCategory(CategoryDTO categoryDTO) {
			Category category = modelMapper.map(categoryDTO, Category.class);
			categoryRepository.save(category);		
	}
	
	public void updateCategory(Long id, CategoryDTO categoryDTO) {
		if (categoryRepository.findById(id).isPresent()){
			Category category = modelMapper.map(categoryDTO, Category.class);
			category.setId(id);
			
			categoryRepository.save(category);
		} else {
            throw new EntityNotFoundException("Categoria com ID:" + id.toString() + " não foi encontrada.");
		}
	}

	public void deleteCategory(Long id) {
		if (categoryRepository.findById(id).isPresent()){
			categoryRepository.deleteById(id);
		} else {
            throw new EntityNotFoundException("Categoria com ID:" + id.toString() + " não foi encontrada.");
		}
	}
	
}