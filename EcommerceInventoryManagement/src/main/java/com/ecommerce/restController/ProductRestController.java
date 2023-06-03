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
	public Response addProduct(@Valid Product product) {

		try {

			productDaoInterface.addProduct(product);
			return Response.status(200).entity("Added Product Successfully").build();

		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}

	}

	@POST
	@Path("/delete/product/{productId}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response deleteProduct(@PathParam("productId") int productId) {

		try {

			productDaoInterface.deleteProduct(productId);
			return Response.status(200).entity("Deleted Product Successfully").build();

		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}

	}
	
	@PUT
	@Path("/update/product/{productId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateProduct(@Valid Product product) {

		try {

			productDaoInterface.updateProduct(product);
			return Response.status(200).entity("updated Product Successfully").build();

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
			
			return Response.status(200).entity("stock "+stock).build();

		} catch (Exception e) {
			return Response.status(500).entity(e.getMessage()).build();
		}

	}

}
