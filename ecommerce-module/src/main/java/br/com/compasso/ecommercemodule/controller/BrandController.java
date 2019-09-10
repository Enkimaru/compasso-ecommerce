package br.com.compasso.ecommercemodule.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import br.com.compasso.ecommercemodule.models.Brand;
import br.com.compasso.ecommercemodule.service.BrandService;

@RestController
@RequestMapping("/brand")
public class BrandController {

	@Autowired
	public BrandService brandService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Brand>> getAllBrand(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size) {
		return new ResponseEntity<>(brandService.getAllBrand(page, size), HttpStatus.OK);
	}
	
	@GetMapping(params = "name")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Brand> getBrandByName(String name) {
		return new ResponseEntity<>(brandService.getBrandByName(name), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Brand> getBrandById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(brandService.getBrandById(id), HttpStatus.OK);
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