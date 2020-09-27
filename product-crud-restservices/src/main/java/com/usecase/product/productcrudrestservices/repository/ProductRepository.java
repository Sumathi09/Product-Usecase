/**
 * 
 */
package com.usecase.product.productcrudrestservices.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.usecase.product.productcrudrestservices.model.Product;

/**
 * @author Sumathi V
 *
 */
public interface ProductRepository extends MongoRepository<Product, String>{

}
