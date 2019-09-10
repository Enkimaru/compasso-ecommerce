package br.com.compasso.ecommercemodule.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.compasso.ecommercemodule.client.BrandClient;
import br.com.compasso.ecommercemodule.models.Brand;

@Service
public class BrandService {
	
	@Autowired
	public BrandClient brandClient;
	
	public List<Brand> getAllBrand(
			@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "size", required = false) String size
			) {
		return brandClient.getAllBrand(page, size);
	}
	
	public Brand getBrandById(Long id) {
		return brandClient.getBrandById(id);
	}

	public Brand getBrandByName(String name) {
		return brandClient.getBrandByName(name);
	}
 
	public Brand createBrand(Brand brand) {
		return brandClient.createBrand(brand);		
	}
	
	public Brand updateBrand(Brand brand) {
		return brandClient.updateBrand(brand);
	}

	public void deleteBrand(Brand brand) {
			brandClient.deleteBrand(brand);
	}
	
}