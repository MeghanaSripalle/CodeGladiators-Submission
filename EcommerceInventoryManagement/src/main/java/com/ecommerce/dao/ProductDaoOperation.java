/**
 * 
 */
package com.ecommerce.dao;

import com.ecommerce.utils.DBUtils;
import com.ecommerce.bean.Product;
import com.ecommerce.constant.SQLQueriesConstant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author sri.vyshnavi
 *
 */
public class ProductDaoOperation implements ProductDaoInterface {
	private static volatile ProductDaoOperation instance = null;
	private PreparedStatement statement = null;

	private ProductDaoOperation() {
	}

	public static ProductDaoOperation getInstance() {
		if (instance == null) {
			synchronized (ProductDaoOperation.class) {
				instance = new ProductDaoOperation();
			}
		}
		return instance;
	}

	@Override
	public void addProduct(Product product) {
		Connection connection = DBUtils.getConnection();
		statement = null;
		try {
			String sql = SQLQueriesConstant.ADD_PRODUCT;
			statement = connection.prepareStatement(sql);

			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getProductName());
			statement.setInt(3, product.getStock());

			int row = statement.executeUpdate();
			System.out.println(row + " rows affected");
			if (row == 1) {
				System.out.println("Product with productId: " + product.getProductId() + " added");
			}

		} catch (SQLException se) {

			System.out.println(se.getMessage());

		}

	}

	@Override
	public void updateProduct(Product product) {
		Connection connection = DBUtils.getConnection();
		statement = null;
		try {
			String sql = SQLQueriesConstant.UPDATE_PRODUCT;
			statement = connection.prepareStatement(sql);

			statement.setString(1, product.getProductName());
			statement.setInt(2, product.getStock());
			statement.setInt(3, product.getProductId());

			int row = statement.executeUpdate();
			System.out.println(row + " rows affected");
			if (row == 1) {
				System.out.println("Product with productId: " + product.getProductId() + " updated");
			}

		} catch (SQLException se) {

			System.out.println(se.getMessage());

		}

	}

	@Override
	public void deleteProduct(int productId) {
		Connection connection = DBUtils.getConnection();
		statement = null;
		try {
			String sql = SQLQueriesConstant.REMOVE_PRODUCT;
			statement = connection.prepareStatement(sql);

			statement.setInt(1, productId);

			int row = statement.executeUpdate();
			System.out.println(row + " rows affected");
			if (row == 1) {
				System.out.println("Product with productId: " + productId + " deleted");
			}

		} catch (SQLException se) {

			System.out.println(se.getMessage());

		}

	}

	@Override
	public int getStock(int productId) {
		Connection connection = DBUtils.getConnection();
		statement = null;
		try {
			String sql = SQLQueriesConstant.GET_STOCK;
			statement = connection.prepareStatement(sql);

			statement.setInt(1, productId);

			ResultSet rs = statement.executeQuery();
			if (rs.next())
			{
				System.out.println("hhmghgcfcghj");
				return rs.getInt("stock");
			}

			return 0;

		} catch (SQLException se) {

			System.out.println(se.getMessage());

		}
		return 0;

	}
}
