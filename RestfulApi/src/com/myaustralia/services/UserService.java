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

import com.myaustralia.entities.*;
import com.myaustralia.repositories.*;

@Path("/DashboardUserService")
public class UserService {
	
	UserRepository repo = new UserRepository();
	
	// http://localhost:8088/RestfulApi/reports/DashboardUserService/getHelloMessage  
	@Path("/getHelloMessage")
	@GET   
	@Produces(MediaType.APPLICATION_JSON)  
	public Response getHelloMessage() {
		return Response.status(201).entity("Hello world").build();
	}

	// http://localhost:8088/RestfulApi/reports/DashboardUserService/users
	@GET
	@Path("users")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUsers(){
		return repo.getUsers();
	}
	
	@POST
	@Path("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User user)
	{
		repo.create(user);
		return user;
	}
	
	@PUT
	@Path("user")
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(User user)
	{
		repo.update(user);
		return user;
	}

	// http://localhost:8088/RestfulApi/reports/DashboardUserService/user/user005
	@DELETE
	@Path("user/{userName}")
	public void deleteUser(@PathParam("userName") String userName)
	{
		repo.delete(userName);
	}
	
}