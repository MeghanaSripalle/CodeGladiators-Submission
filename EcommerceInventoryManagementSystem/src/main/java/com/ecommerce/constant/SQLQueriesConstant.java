/**
 * 
 */
package com.ecommerce.constant;

/**
 * @author sri.vyshnavi
 *
 */
public class SQLQueriesConstant {
	public static final String ADD_PRODUCT = "insert into Products values (?,?,?)";
	public static final String REMOVE_PRODUCT = "delete from Products where productId=?";
	public static final String UPDATE_PRODUCT = "update Products set productName=?, stock=? where productId=?";
	public static final String GET_STOCK = "select stock from Products where productId=?";

}
