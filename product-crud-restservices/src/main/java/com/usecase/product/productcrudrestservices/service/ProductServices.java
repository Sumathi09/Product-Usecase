/**
 * 
 */
package com.usecase.product.productcrudrestservices.service;

import java.util.List;
import java.util.Optional;

import com.usecase.product.productcrudrestservices.model.Product;

/**
 * @author Sumathi V
 *
 */
public interface ProductServices {
	 
	Product addProduct(Product product);
	
	Product updateProduct(Product product);
	
	List<Product> getAllProducts();
	
	Optional<Product> getProductById(String id);
	
	void removeProduct(String id);
	
	String deleteAllCache();

	void deleteAll();

}
