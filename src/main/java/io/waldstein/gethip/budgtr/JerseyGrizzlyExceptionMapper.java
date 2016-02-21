package io.waldstein.gethip.budgtr;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import org.glassfish.grizzly.utils.Exceptions;

@Provider
public class JerseyGrizzlyExceptionMapper implements ExceptionMapper<WebApplicationException> {
	@Override
	public Response toResponse(WebApplicationException ex) {
		return Response.status(500).entity(Exceptions.getStackTraceAsString(ex)).type("text/plain").build();
	}
}
