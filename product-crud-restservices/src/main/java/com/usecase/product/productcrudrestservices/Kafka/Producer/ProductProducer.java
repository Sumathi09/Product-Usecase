/**
 * 
 */
package com.usecase.product.productcrudrestservices.Kafka.Producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.product.productcrudrestservices.model.ProductPrice;

/**
 * @author SVAJARA
 *
 */
@RestController
@RequestMapping("kafka")
public class ProductProducer {

	private static final String TOPIC_NAME="Producer_Topic";
	
	@Autowired
	private KafkaTemplate<String, ProductPrice> kafkaTemplate;
	
	@PostMapping("/publish")
	public String publishPriceForProduct(@RequestBody ProductPrice product) {
		
		kafkaTemplate.send(TOPIC_NAME, product);
		return "Published to Product Topic in Kafka Successfully ";
	}
	
}
