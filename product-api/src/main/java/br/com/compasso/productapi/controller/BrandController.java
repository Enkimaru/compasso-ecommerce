package br.com.compasso.productapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

import br.com.compasso.productapi.models.Brand;
import br.com.compasso.productapi.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	public BrandService brandService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Brand> getAllBrand(@PageableDefault(page=0, size=5) Pageable pageable) {
		return brandService.getAllBrand(pageable);
	}
	
	@GetMapping (params = "name")
	public Brand getBrandByName(String name) {
		Optional<Brand> brand = brandService.getBrandByName(name);
		if (brand.isPresent()) {
			return brand.get();
		}
		return null;
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Brand getBrandById(@PathVariable("id") Long id) {
		Optional<Brand> brand = brandService.getBrandById(id);
		
		if (brand.isPresent()) {
			return brand.get();
		}
		
		return null;
	}

	@PostMapping(path = "/createBrand", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Brand createBrand(@RequestBody Brand brand) {
		return brandService.createBrand(brand);		
	}
	
	@PutMapping(path = "/updateBrand", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Brand updateBrand(@RequestBody Brand brand) {
		return brandService.updateBrand(brand);
	}
	
	@DeleteMapping(path = "/deleteBrand", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public void deleteBrand(@RequestBody Brand brand) {
		brandService.deleteBrand(brand);
	}
	
}