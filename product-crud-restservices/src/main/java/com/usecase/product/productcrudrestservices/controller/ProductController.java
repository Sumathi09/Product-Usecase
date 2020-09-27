/**
 * 
 */
package com.usecase.product.productcrudrestservices.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.usecase.product.productcrudrestservices.Exception.ProductNotFoundException;
import com.usecase.product.productcrudrestservices.model.Product;
import com.usecase.product.productcrudrestservices.service.ProductServices;

/**
 * @author Sumathi V
 *
 */

@RestController
public class ProductController {
	
	private final Logger LOG = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductServices productService;

	@GetMapping("/product")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}


	@GetMapping("/product/{id}")
	public Optional<Product> getProductById(@PathVariable(value="id") String id){
		Optional<Product> product= productService.getProductById(id);

		if(!product.isPresent()) {
			LOG.debug("Product Not Found _id:" +id );
			throw new ProductNotFoundException("-id" +id);
		}
		return product;
	}


	@PutMapping("/product")
	public Product updateProduct(@Valid @RequestBody Product product) {
		return productService.updateProduct(product);

	}

	// input- details of Product
	// output- CREATED & Return the created URI
	@PostMapping("/product")
	public ResponseEntity<Object> addProduct(@Valid @RequestBody Product product) {
		productService.addProduct(product);

		URI location= ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(product.getId()).toUri();

		return ResponseEntity.created(location).build();

	}

	@DeleteMapping("/product/{id}")
	public String deleteProduct(@PathVariable(value="id") String id) {

		if(id!=null) {
			if(!productService.getProductById(id).isPresent()) {
				LOG.debug("Product Not Found _id:" +id );
				throw new ProductNotFoundException("-id" +id);}
		}
		productService.removeProduct(id);

		return "Product deleted successfully: " +id;

	}

	@GetMapping("/deleteCache")
	public String deleteCache() {
		return productService.deleteAllCache();
	}

}
