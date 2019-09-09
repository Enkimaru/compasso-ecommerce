package br.com.compasso.productapi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.productapi.models.Brand;
import br.com.compasso.productapi.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	public BrandRepository brandRepository;

	public Page<Brand> getAllBrand(@PageableDefault(page=0, size=5) Pageable paginacao) {
		return brandRepository.findAll(paginacao);
	}
	
	public ResponseEntity<Optional<Brand>> getBrandById(@PathVariable("id") Long id) {
		Optional<Brand> brand = brandRepository.findById(id);
		
		if (brand.isPresent()) {
			return ResponseEntity.ok(brand);
		}
		return ResponseEntity.notFound().build();
	}

	public void createBrand(@RequestBody Brand brand) {
		brandRepository.save(brand);		
	}
	
	public Brand updateBrand(Brand brand) {
		if (brandRepository.findById(brand.getId()).isPresent()){
			return brandRepository.save(brand);
		}
		return null;
	}
	
}