package br.com.skip.rest.endpoints;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.skip.business.CousineBusiness;
import br.com.skip.business.StoreBusiness;
import br.com.skip.model.Cousine;
import br.com.skip.model.Store;
import br.com.skip.rest.AbstractEndPoint;

@Path("/Cousine")
public class CousineEndPoint extends AbstractEndPoint {

	private final CousineBusiness cousineBusiness = new CousineBusiness();
	
	@GET
	@Path("/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response listCousine() {
		
		try {
			
			List<Cousine> responseObject = cousineBusiness.list();
			
			return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(responseObject)).build();
		
		} catch (Throwable e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error").build();
		}
	}
	
	@GET
	@Path("/search/{searchText}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response search(@PathParam("searchText") String searchText) {
		
		try {
			
			List<Cousine> responseObject = cousineBusiness.list(searchText);
			
			return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(responseObject)).build();
		
		} catch (Throwable e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error").build();
		}
		
	}
	
	@GET
	@Path("/{cousineId}/stores")
	public Response search(@PathParam("cousineId") int cousineId) {
		
		StoreBusiness storeBusiness = new StoreBusiness();
		
		try {
			
			List<Store> responseObject = storeBusiness.list(cousineId);
			
			return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(responseObject)).build();
		
		} catch (Throwable e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error").build();
		}
		
	}
}
