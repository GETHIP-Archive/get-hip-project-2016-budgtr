package io.waldstein.gethip.budgtr;

import java.sql.Date;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.waldstein.gethip.budgtr.model.Transaction;
import io.waldstein.gethip.budgtr.model.User;

@Path("test")
public class TestResource {
	
	@POST
	@Path("create-test-user")
	@Produces(MediaType.APPLICATION_JSON)
	public User createTestUser(){
		User user = new User();
		user.email = "test@test.com";
		user.firstName = "Harley";
		user.lastName = "Waldstein";
		user.password = "Test123";
		user.save();
		return user;
	}
	
	/*
	@POST
	@Path("create-test-transaction")
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction createTestTransaction(){
		Transaction t = new Transaction(2);
		long unixTime = System.currentTimeMillis() / 1000L;
		t.date = new Date(unixTime);
		t.amountInCents = 1234;
		t.description = "Test description, please ignore.";
		t.payee = "Dad";
		t.save();
		return t;
	}
	*/
}
