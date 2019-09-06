package br.com.compasso.ecommercemodule.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compasso.ecommercemodule.models.Product;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/teste")
public class ProductResource {
	
		@Autowired
		private ProductClient productClient;

	    @RequestMapping("/{userId}")
	    public Product getCatalog(@PathVariable("userId") Integer userId) {	    	
			return productClient.getCatalog(userId);
	    
	    }
	}


