package br.com.skip.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

import br.com.skip.business.CustomerBusiness;
import br.com.skip.business.OrderBusiness;
import br.com.skip.model.Order;
import br.com.skip.rest.AbstractEndPoint;

@Path("/Order")
public class OrderEndPoint extends AbstractEndPoint {

	@GET
	@Path("/{orderId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOrder(@PathParam("orderId") int orderId, @HeaderParam("token") String token) {
		
		try {
			
			CustomerBusiness customerBusiness = new CustomerBusiness();
			if (!customerBusiness.checkToken(token)) {
				return Response.status(Response.Status.UNAUTHORIZED).entity(mapper.writeValueAsString("Token Expired")).build();
			}
			
			OrderBusiness bus = new OrderBusiness();
			Order order = bus.getById(orderId);
			
			return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(order)).build();
		
		} catch (Throwable e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error").build();
		}
		
	}
	
	@POST
	@Path("/")
	public Response list(JSONObject request) {
		//TODO
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Not implemented yet").build();
	}
	
	@GET
	@Path("/customer")
	public Response customer() {
		//TODO
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Not implemented yet").build();
	}
	
}
