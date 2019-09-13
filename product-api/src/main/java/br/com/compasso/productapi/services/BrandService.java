package br.com.compasso.productapi.services;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.compasso.productapi.models.Brand;
import br.com.compasso.productapi.models.dtos.BrandDTO;
import br.com.compasso.productapi.repositories.BrandRepository;

@Service
public class BrandService {

	@Autowired
	public BrandRepository brandRepository;
	
	@Autowired
	public ModelMapper modelMapper;

	public List<Brand> getBrand(Pageable pageable) {
		return brandRepository.findAll(pageable).getContent();
	}
	
	public Brand getBrandById(Long id) {
		if (brandRepository.findById(id).isPresent()) {
			return brandRepository.findById(id).get();
		} else {
            throw new EntityNotFoundException("Categoria com ID:" + id.toString() + " não foi encontrada.");
		}	
	}

	public void createBrand(BrandDTO brandDTO) {
			Brand brand = modelMapper.map(brandDTO, Brand.class);
			brandRepository.save(brand);		
	}
	
	public void updateBrand(Long id, BrandDTO brandDTO) {
		if (brandRepository.findById(id).isPresent()){
			Brand brand = modelMapper.map(brandDTO, Brand.class);
			brand.setId(id);
			
			brandRepository.save(brand);
		} else {
            throw new EntityNotFoundException("Categoria com ID:" + id.toString() + " não foi encontrada.");
		}
	}

	public void deleteBrand(Long id) {
		if (brandRepository.findById(id).isPresent()){
			brandRepository.deleteById(id);
		} else {
            throw new EntityNotFoundException("Categoria com ID:" + id.toString() + " não foi encontrada.");
		}
	}
	
}