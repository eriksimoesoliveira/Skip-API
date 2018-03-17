package br.com.skip.rest.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

import br.com.skip.rest.AbstractEndPoint;

@Path("/Store")
public class StoreEndPoint extends AbstractEndPoint {

	@Path("/")
	@GET
	public Response save(JSONObject request) {
		//TODO
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Not implemented yet").build();
	}
	
	@Path("/search/{searchText}")
	@GET
	public Response search(JSONObject request) {
		//TODO
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Not implemented yet").build();
	}
	
	@Path("/{storeId}")
	@GET
	public Response get(JSONObject request) {
		//TODO
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Not implemented yet").build();
	}
	
	@Path("/{storeId}/products")
	@GET
	public Response list(JSONObject request) {
		//TODO
		return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Not implemented yet").build();
	}
	
}
