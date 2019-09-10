package br.com.compasso.ecommercemodule.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.compasso.ecommercemodule.models.Brand;

//@FeignClient(value = "product-api")
@FeignClient(url = "http://localhost:8091", name = "brand")
public interface BrandClient {
	
    @GetMapping(value = "/brand")
    public List<Brand> getAllBrand(@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "size", required = false) String size);

    @GetMapping(value = "/brand")
    public Brand getBrandByName(@RequestParam String name);

    @GetMapping(value = "/brand/{id}")
	public Brand getBrandById(@PathVariable Long id);

    @PostMapping(value = "/brand/createBrand")
	public Brand createBrand(Brand brand);

    @PutMapping(value = "/brand/updateBrand")
	public Brand updateBrand(Brand brand);

    @DeleteMapping(value = "/brand/deleteBrand")
	public void deleteBrand(Brand brand);
    
}