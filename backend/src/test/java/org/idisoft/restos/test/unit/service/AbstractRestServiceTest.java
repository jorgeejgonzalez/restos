package org.idisoft.restos.test.unit.service;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public abstract class AbstractRestServiceTest {
	
	protected void assertOK(Response response)
	{
		assertEquals(Status.OK.getStatusCode(), response.getStatus());
	}
	
	protected void assertCreated(Response response)
	{
		assertEquals(Status.CREATED.getStatusCode(), response.getStatus());
	}
	
	protected void assertNotFound(Response response)
	{
		assertEquals(Status.NOT_FOUND.getStatusCode(), response.getStatus());
	}
	
	protected void assertUnauthorized(Response response)
	{
		assertEquals(Status.UNAUTHORIZED.getStatusCode(), response.getStatus());
	}
	
	protected void assertNotAcceptable(Response response)
	{
		assertEquals(Status.NOT_ACCEPTABLE.getStatusCode(),response.getStatus());
	}
	
	protected void assertConflict(Response response)
	{
		assertEquals(Status.CONFLICT.getStatusCode(),response.getStatus());
	}

}
