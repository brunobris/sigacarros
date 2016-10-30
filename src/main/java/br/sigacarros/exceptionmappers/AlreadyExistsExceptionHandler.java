package br.sigacarros.exceptionmappers;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.sigacarros.exceptions.AlreadyExistsException;
 
@Provider
public class AlreadyExistsExceptionHandler implements ExceptionMapper<AlreadyExistsException> {
	@Override
	public Response toResponse(AlreadyExistsException exception) 
	{
	    return Response.status(Status.CONFLICT).entity(exception.getMessage()).build();  
	}
}
