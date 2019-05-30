package com.virtualmind.controller.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.virtualmind.model.Topic;
import com.virtualmind.service.TestService;

@Path("/topic")
public class RestTest {

	@Inject
	private TestService testService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Topic actualizaTopic(@QueryParam(value = "id") int id) {
		return testService.callUpdateTopic();
	}

}
