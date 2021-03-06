package com.qa.apartment.integration;

import javax.ws.rs.*;

import com.qa.apartment.business.ApartmentServiceDbImpl;
import com.qa.apartment.persistance.Apartment;
import com.qa.apartment.util.JSONUtil;

import java.util.List;

import javax.inject.*;
@Path("/apartment")
public class ApartmentEndpoint {
	
	@Inject
	JSONUtil jsonUtil; 
	
	@Inject
	ApartmentServiceDbImpl service;
	
	@Path("/json/{id}")
	@GET
	public String getApartment(@PathParam("id") long id) {
		return jsonUtil.getJSONForObject(service.findApartment(id));
	}
	
	@Path("/json")
	@GET
	public String getAllApartments() {
		return jsonUtil.getJSONForObject(service.findAllApartments());
	}
	
	@Path("/json")
	@POST
	public String createApartment(String newAp) {
		return service.createApartment(newAp);
	}
	
	@Path("/json/{id}")
	@DELETE
	public String deleteApartment(@PathParam("id") long id) {
		return service.deleteApartment(id);
	}
	
	@Path("/json/{id}")
	@PUT
	public String updateApartment(String newAp,@PathParam("id") long id) {
		return service.updateApartment(id, newAp);
	}
	
}
