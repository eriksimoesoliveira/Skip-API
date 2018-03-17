package br.com.skip.rest;


import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;
import com.sun.jersey.spi.container.ContainerResponse;
import com.sun.jersey.spi.container.ContainerResponseFilter;

/**
 * @author Denilson.Pinto
 * @date 2017-09-01
 * @project RestAPI
 */
public class JerseyFilter implements ContainerResponseFilter, ContainerRequestFilter {

	@Override
	public ContainerRequest filter(final ContainerRequest request) {
		
		return request;
	}

	@Override
	public ContainerResponse filter(final ContainerRequest request, final ContainerResponse response) {
		
		response.getHttpHeaders().putSingle("Access-Control-Allow-Origin", "*");
		response.getHttpHeaders().putSingle("Access-Control-Allow-Credentials", "true");
		response.getHttpHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS, HEAD");
		response.getHttpHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With, token, programName");
		
		return response;
	}
}
