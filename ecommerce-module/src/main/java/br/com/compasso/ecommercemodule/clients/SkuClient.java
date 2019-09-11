package br.com.compasso.ecommercemodule.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.compasso.ecommercemodule.models.Sku;
import br.com.compasso.ecommercemodule.models.dtos.SkuDTO;

//@FeignClient(value = "sku-api")
@FeignClient(url = "http://localhost:8091", name = "sku")
public interface SkuClient {
	
    @GetMapping(value = "/sku")
    public List<Sku> getSku(@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category);
    
    @GetMapping(value = "/sku/enabled")
    public List<Sku> getSkuEnabled(@RequestParam(value = "page", required = false) String page,
    		@RequestParam(value = "size", required = false) String size,
			@RequestParam(value = "brand", required = false) String brand,
			@RequestParam(value = "category", required = false) String category);

    @GetMapping(value = "/sku")
    public Sku getSkuByName(@RequestParam String name);

    @GetMapping(value = "/sku/{id}")
	public Sku getSkuById(@PathVariable Long id);

    @PostMapping(value = "/sku/createSku")
	public Sku createSku(SkuDTO skuDTO);

    @PutMapping(value = "/sku/updateSku")
	public Sku updateSku(Sku sku);
    
}