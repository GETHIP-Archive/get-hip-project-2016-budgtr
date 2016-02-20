package io.waldstein.gethip.budgtr;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import com.avaje.ebean.Ebean;

import io.waldstein.gethip.budgtr.model.User;

@Path("test")
public class TestResource {

	@POST
	@Path("create-test-user")
	public User createTestUser(){
		User user = new User();
		user.email = "test@test.com";
		user.firstName = "Harley";
		user.lastName = "Waldstein";
		user.password = "Test123";
		user.save();
		return user;
	}
}
