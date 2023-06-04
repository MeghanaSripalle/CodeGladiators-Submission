/**
 * 
 */
package com.ecommerce.exception;

/**
 * @author sri.vyshnavi
 *
 */
public class ProductIdExistException extends Exception {
	private int productId;

	public ProductIdExistException(int id) {
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
		return "Product ID : " + productId + " already exists in the database\n";
	}

}
