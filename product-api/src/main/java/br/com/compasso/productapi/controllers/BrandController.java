package br.com.compasso.productapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

import br.com.compasso.productapi.models.Brand;
import br.com.compasso.productapi.models.dtos.BrandDTO;
import br.com.compasso.productapi.services.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	public BrandService brandService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Brand>> getBrand(@PageableDefault(page=0, size=5) Pageable pageable) {
		return ResponseEntity.ok(brandService.getBrand(pageable));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Brand> getBrandById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(brandService.getBrandById(id));
	}

	@PostMapping
	public ResponseEntity<Void> createBrand(@RequestBody BrandDTO brandDTO) {
		brandService.createBrand(brandDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();		
	}
	
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateBrand(@PathVariable("id") Long id,
			@RequestBody BrandDTO brandDTO) {
			brandService.updateBrand(id, brandDTO);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteBrand(@PathVariable("id") Long id) {
		brandService.deleteBrand(id);
		return ResponseEntity.noContent().build();
	}
	
}