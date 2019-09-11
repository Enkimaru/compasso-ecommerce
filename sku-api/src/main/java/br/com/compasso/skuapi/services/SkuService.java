package br.com.compasso.skuapi.services;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.compasso.skuapi.models.Sku;
import br.com.compasso.skuapi.models.dtos.SkuDTO;
import br.com.compasso.skuapi.repositories.SkuRepository;

@Service
public class SkuService {

	@Autowired
	public SkuRepository skuRepository;
	
	@Autowired
	public ModelMapper modelMapper;

	public List<Sku> getSku(@PageableDefault(page=0, size=5) Pageable pageable) {
		return skuRepository.findAll(pageable).getContent();
	}
	
	public List<Sku> getSkuEnabled(@PageableDefault(page=0, size=5) Pageable pageable) {
		return skuRepository.findByEnabled(true, pageable).getContent();
	}
	
	public Optional<Sku> getSkuById(@PathVariable("id") Long id) {
		return skuRepository.findById(id);
	}
	

	public Sku createSku(@RequestBody SkuDTO skuDTO) {
		Sku sku = modelMapper.map(skuDTO, Sku.class);
		return skuRepository.save(sku);		
	}
	
	public Sku updateSku(Sku sku) {
		if (skuRepository.findById(sku.getId()).isPresent()){
			return skuRepository.save(sku);
		}
		return null;
	}
	
}