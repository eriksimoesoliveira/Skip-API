package br.com.skip.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

import br.com.skip.rest.AbstractEndPoint;

@Path("/Product")
public class ProductEndPoint extends AbstractEndPoint {

	@GET
	@Path("/")
	public Response save(JSONObject request) {
		//TODO
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Not implemented yet").build();
	}
	
	@GET
	@Path("search/{searchText}")
	public Response search(JSONObject request) {
		//TODO
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Not implemented yet").build();
	}
	
	@GET
	@Path("/{productId}")
	public Response get(JSONObject request) {
		//TODO
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Not implemented yet").build();
	}
	
}
