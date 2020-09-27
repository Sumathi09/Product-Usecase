/**
 * 
 */
package com.usecase.product.productcrudrestservices.Kafka.Config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.usecase.product.productcrudrestservices.model.ProductPrice;

/**
 * @author Sumathi V
 *
 */
@EnableKafka
@Configuration
public class ConsumerKafkaConfig {

	private String bootstrapServers= "127.0.0.1:9092";
	private String Group_Id= "product_group";
	private String Group_Id_Price= "product_price";

	@Bean
	public ConsumerFactory<String, String> consumerFactory(){
		Map<String, Object> config= new HashMap<>();

		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		config.put(ConsumerConfig.GROUP_ID_CONFIG, Group_Id);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);

		return new DefaultKafkaConsumerFactory<String, String>(config);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> 
	kafkaListenerContainerFactory(){

		ConcurrentKafkaListenerContainerFactory<String, String> factory= new ConcurrentKafkaListenerContainerFactory<String, String>();
		factory.setConsumerFactory(consumerFactory());
		return factory;

	}

	public ConsumerFactory<String, ProductPrice> productConsumerFactory() {
		Map<String, Object> props = new HashMap<>();

		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, Group_Id_Price);
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(ProductPrice.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, ProductPrice> productKafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, ProductPrice> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(productConsumerFactory());
		return factory;
	}
}
