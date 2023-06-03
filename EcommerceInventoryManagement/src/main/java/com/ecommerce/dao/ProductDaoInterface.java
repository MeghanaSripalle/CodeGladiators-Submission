/**
 * 
 */
package com.ecommerce.dao;

import com.ecommerce.bean.Product;

/**
 * @author sri.vyshnavi
 *
 */
public interface ProductDaoInterface {
	public void addProduct(Product product);

	public void updateProduct(Product product);

	public void deleteProduct(int productId);

	public int getStock(int productId);

}
