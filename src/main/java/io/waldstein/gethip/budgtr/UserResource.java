package io.waldstein.gethip.budgtr;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.avaje.ebean.Ebean;

import io.waldstein.gethip.budgtr.model.User;	

@Path("/user")
public class UserResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public User getUser(@QueryParam("id") long id) {
		return User.find.where().eq("id", id).findUnique();
	};

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public User postUser(User u){	
		Ebean.save(u);
		return u;
	};

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public User putUser(@QueryParam("id") long id, User u){
		User PUT = User.find.where().eq("id", id).findUnique();
		PUT.firstName(u.firstName);
		PUT.lastName(u.lastName);
		PUT.email(u.email);
		PUT.password(u.password);
		PUT.update();
		return PUT;
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Boolean deleteUser(@QueryParam("id") long id){
		User u = User.find.where().eq("id", id).findUnique();
		return Ebean.delete(u);
	};
}