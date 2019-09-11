package br.com.compasso.skuapi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.skuapi.models.Sku;
import br.com.compasso.skuapi.models.dtos.SkuDTO;
import br.com.compasso.skuapi.services.SkuService;

@RestController
@RequestMapping("/sku")
public class SkuController {

	@Autowired
	public SkuService skuService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Sku> getSku(@PageableDefault(page=0, size=5) Pageable pageable) {
		return skuService.getSku(pageable);
	}
	
	@GetMapping("/enabled")
	@ResponseStatus(HttpStatus.OK)
	public List<Sku> getSkuEnabled(@PageableDefault(page=0, size=5) Pageable pageable) {
		return skuService.getSkuEnabled(pageable);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Sku getSkuById(@PathVariable("id") Long id) {
		Optional<Sku> sku = skuService.getSkuById(id);
		
		if (sku.isPresent()) {
			return sku.get();
		}
		
		return null;
	}

	@PostMapping(path = "/createSku", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.CREATED)
	public Sku createSku(@RequestBody SkuDTO skuDTO) {
		return skuService.createSku(skuDTO);		
	}
	
	@PutMapping(path = "/updateSku", consumes = "application/json", produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public Sku updateSku(@RequestBody Sku sku) {
		return skuService.updateSku(sku);
	}
	
}