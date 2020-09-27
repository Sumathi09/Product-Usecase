/**
 * 
 */
package com.usecase.product.productcrudrestservices.model;



/**
 * @author Sumathi V
 *
 */
public class ProductDetails {
	
	
	private String id;
	private String productDesc;
	private String productName;
	private long productPrice;
	
	public ProductDetails() {
	}
	
	public ProductDetails(String id, String productDesc, String productName, long productPrice) {
		super();
		this.id = id;
		this.productDesc = productDesc;
		this.productName = productName;
		this.productPrice = productPrice;
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
	
	public long getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "ProductDetails [id=" + id + ", productDesc=" + productDesc + ", productName=" + productName
				+ ", productPrice=" + productPrice + "]";
	}
}
