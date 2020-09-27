package com.usecase.product.productcrudrestservices.model;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Sumathi V
 *
 */
@Document (collection="product")
public class Product implements Serializable{

	private static final long serialVersionUID = 7156526077883281623L;

	@Id
	private String id;

	@Size(min=2)
	private String productDesc;

	@Size(min=2)
	private String productName;

	public Product() {
	}


	public Product(String id, String productDesc, String productName) {
		super();
		this.id = id;
		this.productDesc = productDesc;
		this.productName = productName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", ProductDesc=" + productDesc + ", ProductName=" + productName
				+ "]";
	}

}
