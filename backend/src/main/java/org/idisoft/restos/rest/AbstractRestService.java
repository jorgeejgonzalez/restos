package org.idisoft.restos.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public abstract class AbstractRestService {
	
	protected Response buildResponse(final Response.Status status, final Object entity)
	{
		Response.ResponseBuilder builder=Response.status(status);
		builder.entity(entity);
		builder.type(MediaType.APPLICATION_JSON);		
		return builder.build();
	}

}
