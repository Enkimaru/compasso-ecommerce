package br.com.compasso.productapi.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.compasso.productapi.models.Brand;
import br.com.compasso.productapi.repository.BrandRepository;
import br.com.compasso.productapi.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	public BrandService brandService;

//	@GetMapping("")
//	@ResponseBody
//	public Page<Brand> getAllBrand(@PageableDefault(page=0, size=5) Pageable paginacao) {
//		return brandRepository.findAll(paginacao);
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<Optional<Brand>> getBrandById(@PathVariable("id") Long id) {
//		Optional<Brand> brand = brandRepository.findById(id);
//		
//		if (brand.isPresent()) {
//			return ResponseEntity.ok(brand);
//		}
//		return ResponseEntity.notFound().build();
//	}
//
//	@PostMapping(path = "/createBrand", consumes = "application/json", produces = "application/json")
//	public void createBrand(@RequestBody Brand brand) {
//		brandRepository.save(brand);		
//	}
	
	@PutMapping(path = "/updateBrand", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Brand> updateBrand(@RequestBody Brand brand) {
		return new ResponseEntity<>(brandService.updateBrand(brand), HttpStatus.OK);
	}
	
}