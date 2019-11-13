package com.myaustralia.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.myaustralia.repositories.*;
import com.myaustralia.vo.VOReport;

@Path("/ReportService")
public class ReportService {

	ReportRepository repo = new ReportRepository();
	
	// http://localhost:8088/RestfulApi/reports/ReportService/getHelloMessage
	@Path("/getHelloMessage")
	@GET   
	@Produces(MediaType.APPLICATION_JSON)  
	public Response getHelloMessage() {
		return Response.status(201).entity("Hello world").build();
	}
	
	// http://localhost:8088/RestfulApi/reports/ReportService/report/SA Transport
	@GET
	@Path("report/{authority}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getReports(@PathParam("authority") String authority) {
		return repo.getReports(authority);
	}
		
	@POST
	@Path("report")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createReport(VOReport report) {
		repo.create(report);
	}
		
	@PUT
	@Path("report")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateReport(VOReport report) {
		repo.update(report);
	}
		
	@DELETE
	@Path("report/{id}")
	public void deleteReport(@PathParam("id") String id) {
		repo.delete(id);
	}
	
}