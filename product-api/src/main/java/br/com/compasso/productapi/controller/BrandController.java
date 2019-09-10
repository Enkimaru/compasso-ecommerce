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

import br.com.compasso.productapi.models.Brand;
import br.com.compasso.productapi.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	public BrandService brandService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public Page<Brand> getBrand(@PageableDefault(page=0, size=5) Pageable pageable) {
		return brandService.getAllBrand(pageable);
	}
	
	@GetMapping (params = "name")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Brand> getBrandByName(String name) {
		Optional<Brand> brand = brandService.getBrandByName(name);
		if (brand.isPresent()) {
			return new ResponseEntity<>(brand.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Brand> getBrandById(@PathVariable("id") Long id) {
		Optional<Brand> brand = brandService.getBrandById(id);
		
		if (brand.isPresent()) {
			return new ResponseEntity<>(brand.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping(path = "/createBrand", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Brand> createBrand(@RequestBody Brand brand) {
		return new ResponseEntity<>(brandService.createBrand(brand), HttpStatus.OK);		
	}
	
	@PutMapping(path = "/updateBrand", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Brand> updateBrand(@RequestBody Brand brand) {
		return new ResponseEntity<>(brandService.updateBrand(brand), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/deleteBrand", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Brand> deleteBrand(@RequestBody Brand brand) {
		brandService.deleteBrand(brand);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}