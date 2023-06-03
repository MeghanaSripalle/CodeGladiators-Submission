/**
 * 
 */
package com.ecommerce.bean;

/**
 * @author sri.vyshnavi
 *
 */
public class Product {
	private int productId;
	private String productName;
	private int stock;
	public Product() {
		
	}

	public Product(int productId, String productName, int stock) {
		
		this.productId = productId;
		this.productName = productName;
		this.stock = stock;
	}

	/**
	 * @return the productId
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

}
