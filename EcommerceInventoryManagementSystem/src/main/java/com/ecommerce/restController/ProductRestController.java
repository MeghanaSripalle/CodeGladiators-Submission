/**
 * 
 */
package com.ecommerce.restController;

import com.ecommerce.bean.Product;
import javax.validation.Valid;
import com.ecommerce.dao.ProductDaoInterface;
import com.ecommerce.dao.ProductDaoOperation;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import com.ecommerce.exception.ProductNotFoundException;

/**
 * @author sri.vyshnavi
 *
 */
@Path("/ecommerce")
public class ProductRestController {
	ProductDaoInterface productDaoInterface = ProductDaoOperation.getInstance();

	@POST
	@Path("/add/product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response addProduct(@Valid ArrayList<Product> products) {
		String responseString = "";
		try {
			for (Product i : products) {
				try {
					productDaoInterface.addProduct(i);
					responseString += "Product ID : " + i.getProductId() + " added\n";
				} catch (Exception e) {
					responseString += e.getMessage();
				}
			}

			return Response.status(200).entity(responseString).build();

		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}

	}

	@POST
	@Path("/delete/product")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteProduct(ArrayList<Product> products) {

		try {
			String responseString = "";
			for (Product i : products) {
				try {
					productDaoInterface.deleteProduct(i.getProductId());
					responseString += "Product ID : " + i.getProductId() + " deleted\n";
				} catch (Exception e) {
					responseString += e.getMessage();
				}

			}

			return Response.status(200).entity(responseString).build();

		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}

	}

	@PUT
	@Path("/update/product/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateProduct(@Valid ArrayList<Product> products) {

		try {
			String responseString = "";
			for (Product i : products) {
				try {
					productDaoInterface.updateProduct(i);
					responseString += "Product ID : " + i.getProductId() + " updated\n";
				} catch (Exception e) {
					responseString += e.getMessage();
				}

			}
			return Response.status(200).entity(responseString).build();

		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}

	}

	@GET
	@Path("/getStock/product/{productId}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getStock(@PathParam("productId") int productId) {

		try {
			System.out.println(productId);
			int stock = productDaoInterface.getStock(productId);

			return Response.status(200).entity("Product ID : "+productId+" Stock - " + stock).build();

		} catch (ProductNotFoundException e) {
			return Response.status(200).entity(e.getMessage()).build();
		}

	}

}
