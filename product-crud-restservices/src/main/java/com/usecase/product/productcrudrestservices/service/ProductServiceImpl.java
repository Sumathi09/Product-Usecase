/**
 * 
 */
package com.usecase.product.productcrudrestservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import com.usecase.product.productcrudrestservices.model.Product;
import com.usecase.product.productcrudrestservices.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

/**
 * @author Sumathi V
 *
 */
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductServices {

	@Autowired
	private ProductRepository repository;


	@Override
	public Product addProduct(Product product) {
		return repository.save(product);

	}

	@Override
	@CachePut(value = "products", key = "#product.id")
	public Product updateProduct(Product prod) {

		Product matchedProduct= new Product();
		List<Product> products= repository.findAll();
		for(Product product: products) {
			if(product.getId().equalsIgnoreCase(prod.getId())) {
				matchedProduct= product;
			}
		}
		matchedProduct.setProductName(prod.getProductName());
		matchedProduct.setProductDesc(prod.getProductDesc());
		repository.save(matchedProduct);
		return matchedProduct;
	}

	@Override
	public List<Product> getAllProducts(){
		List<Product> products= repository.findAll();
		return products;
	}

	@Override
	@Cacheable(value = "products", key = "#id")
	public Optional<Product> getProductById(String id){
		return repository.findById(id);
	}

	@Override
	@CacheEvict(value = "products", key = "#id")
	public void removeProduct(String id) {
		repository.deleteById(id);
	}

	@Override
	@CacheEvict(allEntries = true, value = "products")
	public String deleteAllCache() {
		return "Deleted Full Cache";
	}

	@Override
	@CacheEvict(allEntries = true, value = "products")
	public void deleteAll() {
		repository.deleteAll();
	}

}
