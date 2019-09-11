package br.com.compasso.productapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.compasso.productapi.models.Brand;
import br.com.compasso.productapi.repositories.BrandRepository;

@Service
public class BrandService {

	@Autowired
	public BrandRepository brandRepository;

	public List<Brand> getAllBrand(@PageableDefault(page=0, size=5) Pageable pageable) {
		return brandRepository.findAll(pageable).getContent();
	}
	
	public Optional<Brand> getBrandById(@PathVariable("id") Long id) {
		return brandRepository.findById(id);
	}
	
	public Optional<Brand> getBrandByName(@PathVariable("name") String name) {
		return brandRepository.findByNameIgnoreCase(name);
	}

	public Brand createBrand(@RequestBody Brand brand) {
		return brandRepository.save(brand);		
	}
	
	public Brand updateBrand(Brand brand) {
		if (brandRepository.findById(brand.getId()).isPresent()){
			return brandRepository.save(brand);
		}
		return null;
	}

	public void deleteBrand(Brand brand) {
		if (brandRepository.findById(brand.getId()).isPresent()){
			brandRepository.delete(brand);
		}
	}
	
}