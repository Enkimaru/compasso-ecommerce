package br.com.compasso.skustatusapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.skustatusapi.services.SkuStatusService;

@RestController
@RequestMapping("/skuStatus")
public class SkuStatusController {

	@Autowired
	public SkuStatusService skuStatusService;
	
	@PutMapping("/deactivateSku/{id}")
	public Integer deactivateSku(@PathVariable("id") Long id) {
		return skuStatusService.deactivateSku(id);
	}
	
	@PutMapping("/activateSku/{id}")
	public Integer activateSku(@PathVariable("id") Long id) {
		return skuStatusService.activateSku(id);
	}
}