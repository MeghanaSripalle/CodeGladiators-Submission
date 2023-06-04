/**
 * 
 */
package com.ecommerce.exception;

/**
 * @author sri.vyshnavi
 *
 */
public class ProductNotFoundException extends Exception {
	private int productId;

	public ProductNotFoundException(int id) {
		this.productId = id;
	}

	public void setProductId(int id) {
		this.productId = id;
		
	}

	public int getProductId() {
		return productId;
	}

	@Override
	public String getMessage() {
		return "Product ID : " + productId + " not found in the database\n";
	}

}
