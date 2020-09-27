package com.usecase.product.productcrudrestservices.model;



/**
 * @author Sumathi V
 *
 */
public class ProductPrice {

	private String productId;

	private long productPrice;

	public ProductPrice() {

	}

	public ProductPrice(String productId, long productPrice) {
		super();
		this.productId = productId;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	@Override
	public String toString() {
		return "ProductwithPrice [productId=" + productId + ", productPrice=" + productPrice + "]";
	}

}
