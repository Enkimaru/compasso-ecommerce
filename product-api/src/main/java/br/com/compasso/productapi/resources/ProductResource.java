package br.com.compasso.productapi.resources;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.productapi.models.Brand;
import br.com.compasso.productapi.models.Product;
import br.com.compasso.productapi.repository.BrandRepository;

@RestController
@RequestMapping("/product")
public class ProductResource {

	@Autowired
	public BrandRepository brandRepository;

//	
	@RequestMapping("/{id}")
	public Product getProduct(@PathVariable("id") Integer id) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		Product product = new Product();
		return product;

	}

	@RequestMapping("/brand/")
	@ResponseBody
	public List<Brand> getAllBrand() {

		Brand brand = new Brand();


		List<Brand> brands = (List<Brand>) brandRepository.findAll();

		System.out.println(brands);

		return brands;

	}

	@RequestMapping("/brand/{id}")
	public Optional<Brand> getBrand(@PathVariable("id") Long id) {
		System.out.println(id);

		Optional<Brand> brand = brandRepository.findById(id);

		return brand;

	}

	@RequestMapping("/brand/create/{name}")
	public Brand createBrand(@PathVariable("name") String name) {

		System.out.println(name);
		Brand brand = new Brand();
		brand.setName(name);

		brandRepository.save(brand);

		System.out.println("teste");

		return brand;

	}

	@PostMapping(path = "/brand/addBrand", consumes = "application/json", produces = "application/json")
	public void addMember(@RequestBody Brand brand) {
		brandRepository.save(brand);
		System.out.println(brand.getName());
		System.out.println("Teste");
	}
	
	@RequestMapping("/brand/name/{name}")
	public Brand searchBrand(@PathVariable("name") String name) {

		System.out.println(name);
		Brand brand = brandRepository.findByName(name);

		return brand;

	}
}