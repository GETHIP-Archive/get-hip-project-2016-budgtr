package io.waldstein.gethip.budgtr;

import java.sql.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.waldstein.gethip.budgtr.model.Transaction;
import io.waldstein.gethip.budgtr.model.User;

@Path("transactions")
public class TransactionResource {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getTransactionsByAccount(@QueryParam("userId") long userId) {
        return Transaction.find.where().eq("user_id", userId).findList();
    }
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction createTransaction(@FormParam("date") String date, @FormParam("payee") String payee,
    		@FormParam("category") String category, @FormParam("description") String description, @FormParam("dollars") String dollars,
    		@FormParam("cents") String cents) {
		
		String userId = "4";
		
		Transaction t = new Transaction();
		t.date = new Date(System.currentTimeMillis());
		t.payee = payee;
		t.category = category;
		t.description = description;
		t.dollars = Long.parseLong(dollars.trim());
		t.cents = Long.parseLong(cents.trim());
		t.userId = 4;
		t.user = User.find.where().idEq(4).findUnique();
		t.save();
		return t;
    }
	   
}
