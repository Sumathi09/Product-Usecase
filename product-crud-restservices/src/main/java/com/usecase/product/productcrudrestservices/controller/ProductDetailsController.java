package com.usecase.product.productcrudrestservices.controller;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.product.productcrudrestservices.Exception.ProductNotFoundException;
import com.usecase.product.productcrudrestservices.constants.Constants;
import com.usecase.product.productcrudrestservices.model.Product;
import com.usecase.product.productcrudrestservices.model.ProductDetails;
import com.usecase.product.productcrudrestservices.model.ProductPrice;
import com.usecase.product.productcrudrestservices.service.ProductServices;

/**
 * @author Sumathi V
 *
 */
@RestController
public class ProductDetailsController {

	private final Logger LOG = LoggerFactory.getLogger(ProductDetailsController.class);
	
	@Autowired
	private ProductServices productService;


	@GetMapping("/getProductDetails/{id}")
	public ProductDetails getProductById(@PathVariable(value="id") String id){
		Optional<Product> product= productService.getProductById(id);

		if(!product.isPresent()) {
			LOG.debug("Product Not Found _id:" +id );
			throw new ProductNotFoundException("-id" +id);
		}

		ProductDetails details= new ProductDetails();
		ProductPrice price= Constants.CONSTANT_MAP.get(id);
		details.setId(id);
		details.setProductPrice(price.getProductPrice());
		details.setProductDesc(product.get().getProductDesc());
		details.setProductName(product.get().getProductName());

		return details;
	}

}
