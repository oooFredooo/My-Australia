package com.myaustralia.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.myaustralia.repositories.*;

@Path("visualization")
public class VisualizationService {

	// http://localhost:8088/RestfulApi/reports/visualization/getHelloMessage
	@Path("/getHelloMessage")
	@GET   
	@Produces(MediaType.APPLICATION_JSON)  
	public Response getHelloMessage() {
		return Response.status(201).entity("Hello world").build();
	}
	
	// http://localhost:8088/RestfulApi/reports/visualization/getmapmarkers/Admin
	MapMarkerRepository mapMarkerRepo = new MapMarkerRepository();
	@Path("/getmapmarkers/{authority}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMapMarkers(@PathParam("authority") String authority) {
		return mapMarkerRepo.getMapMarkers(authority);
	}
	
	// http://localhost:8088/RestfulApi/reports/visualization/getmapmarkerclusters/Admin
	MapMarkerClusterRepository mapMarkerClusterRepo = new MapMarkerClusterRepository();
	@Path("/getmapmarkerclusters/{authority}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getMapMarkerClusters(@PathParam("authority") String authority) {
		return mapMarkerClusterRepo.getMapMarkerClusters(authority);
	}
	
	ChartRepository chartRepo = new ChartRepository();
	// http://localhost:8088/RestfulApi/reports/visualization/getsuburbcount/Admin
	@Path("/getsuburbcount/{authority}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getSuburbCount(@PathParam("authority") String authority) {
		return chartRepo.getSuburbCount(authority);
	}
	
	// http://localhost:8088/RestfulApi/reports/visualization/getroutecount/Admin
	@Path("/getroutecount/{authority}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getRouteCount(@PathParam("authority") String authority) {
		return chartRepo.getRouteCount(authority);
	}
}