/**
 * 
 */
package com.ecommerce.dao;

import com.ecommerce.bean.Product;
import com.ecommerce.exception.ProductIdExistException;
import com.ecommerce.exception.ProductNotFoundException;

/**
 * @author sri.vyshnavi
 *
 */
public interface ProductDaoInterface {
	public void addProduct(Product product) throws ProductIdExistException;

	public void updateProduct(Product product) throws ProductNotFoundException;

	public void deleteProduct(int productId) throws ProductNotFoundException;

	public int getStock(int productId) throws ProductNotFoundException;

}
