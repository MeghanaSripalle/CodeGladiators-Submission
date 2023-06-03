/**
 * 
 */
package com.ecommerce.utils;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {

	private static Connection connection = null;

	public static Connection getConnection() {

		if (connection != null) {
			try {
				if (connection.isClosed()) {
					System.out.println("Connection was closed...");
					connection = null;
					return getConnection();
				} else {

					return connection;
				}
			} catch (SQLException e) {

				return getConnection();
			}
		} else {
			try {

				

				String driver = "com.mysql.cj.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/EcommerceDatabase";

				String user = "root";
				String password = "12345678";
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			return connection;
		}

	}
}
