package br.com.compasso.ecommercemodule.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.ecommercemodule.models.Sku;
import br.com.compasso.ecommercemodule.services.SkuService;

@RestController
@RequestMapping("/sku")
public class SkuController {

	@Autowired
	public SkuService skuService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Sku>> getSku(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category) {
		return new ResponseEntity<>(skuService.getSku(page, size, brand, category), HttpStatus.OK);
	}
	
	@GetMapping("/enabled")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Sku>> getSkuEnabled(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category) {
		return new ResponseEntity<>(skuService.getSkuEnabled(page, size, brand, category), HttpStatus.OK);
	}
	
	@GetMapping(params = "name")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Sku> getSkuByName(String name) {
		return new ResponseEntity<>(skuService.getSkuByName(name), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Sku> getSkuById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(skuService.getSkuById(id), HttpStatus.OK);
	}

	@PostMapping(path = "/createSku", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Sku> createSku(@RequestBody Sku sku) {
		return new ResponseEntity<>(skuService.createSku(sku), HttpStatus.OK);		
	}
	
	@PutMapping(path = "/updateSku", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Sku> updateSku(@RequestBody Sku sku) {
		return new ResponseEntity<>(skuService.updateSku(sku), HttpStatus.OK);
	}
	
	@DeleteMapping(path = "/deactivateSku/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Sku> deactivateSku(@PathVariable("id") Long id) {
		skuService.deactivateSku(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping(path = "/activateSku/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Sku> activateSku(@PathVariable("id") Long id) {
		skuService.activateSku(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}