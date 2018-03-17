package br.com.skip.rest.endpoints;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONObject;

import br.com.skip.business.CustomerBusiness;
import br.com.skip.exception.ValidationException;
import br.com.skip.model.Customer;
import br.com.skip.rest.AbstractEndPoint;
import br.com.skip.rest.dto.AuthenticationDTO;
import br.com.skip.rest.dto.CustomerDTO;

@Path("/Customer")
public class CustomerEndPoint extends AbstractEndPoint {

	private final CustomerBusiness business = new CustomerBusiness();
	
	@POST
	@Path("/auth")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response auth(JSONObject request) {
		
		try {
			//Read JSON
			AuthenticationDTO dto = mapper.readValue(request.toString(), AuthenticationDTO.class);
			
			//Transform DTO to User
			Customer user = new Customer();
			user.setEmail(dto.getEmail());
			user.setPassword(dto.getPassword());
			
			//Check credentials
			boolean valid = business.checkAuthentication(user);
			if (!valid) {
				return Response.status(Response.Status.BAD_REQUEST).entity("User and Password not found.").build();
			}
			
			//Issue token
			String token = business.issueToken(user);
			
			//Return token
			return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(token)).build();
		
		} catch (Throwable e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error").build();
		}
	}
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(JSONObject request) {
		
		try {
			
			//Read JSON
			CustomerDTO dto = mapper.readValue(request.toString(), CustomerDTO.class);
			
			Customer customer = new Customer();
			customer.setAddress(dto.getAddress());
			customer.setCreation(dto.getCreation());
			customer.setEmail(dto.getEmail());
			customer.setId(dto.getId());
			customer.setName(dto.getPassword());
			customer.setPassword(dto.getPassword());
			
			//Validate
			business.validateCustomer(customer);
			
			business.save(customer);
			
			return Response.status(Response.Status.OK).entity(mapper.writeValueAsString(dto)).build();
			
		} catch (ValidationException e) {
			try {
				return Response.status(Response.Status.BAD_REQUEST).entity(mapper.writeValueAsString(e.getMessage())).build();
			} catch (IOException e1) {
				return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error").build();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return Response.status(Response.Status.BAD_REQUEST).entity("Error").build();
		} catch (Throwable e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error").build();
		}
		
	}
	
	
	
}
