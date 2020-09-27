/**
 * 
 */
package com.usecase.product.productcrudrestservices.Kafka.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CachePut;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.usecase.product.productcrudrestservices.constants.Constants;
import com.usecase.product.productcrudrestservices.model.ProductPrice;

/**
 * @author Sumathi V
 *
 */
@Service
public class ProductPriceConsumer {

	private final Logger LOG = LoggerFactory.getLogger(ProductPriceConsumer.class);


	@CachePut(value = "productsprice", key = "#product.productId")
	@KafkaListener(topics="Producer_Topic",groupId= "product_price",containerFactory = "productKafkaListenerContainerFactory")
	public void consume(ProductPrice product) {
		//System.out.println("consumed message: " + " Productid:" +product.getProductId() + " ProductPrice:" +product.getProductPrice());
		LOG.debug("consumed message: " + " Productid:" +product.getProductId() + " ProductPrice:" +product.getProductPrice());
		updateCache(product);
	}

	public ProductPrice updateCache(ProductPrice product) {
		Constants.CONSTANT_MAP.put(product.getProductId(), product);
		return product;
	}
}
