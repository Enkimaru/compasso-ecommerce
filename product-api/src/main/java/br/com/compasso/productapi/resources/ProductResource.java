package br.com.compasso.productapi.resources;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.compasso.productapi.models.Product;


@RestController
@RequestMapping("/product")
public class ProductResource {
	
	    @RequestMapping("/{userId}")
	    public Product getCatalog(@PathVariable("userId") Integer userId) {
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	    	
	    		    		
	    	Product product = new Product();
	    	product.setId(userId);
	    	product.setDescription("Data agora: " + formatter.format(new Date()));
			return product;
	    
	    }
}