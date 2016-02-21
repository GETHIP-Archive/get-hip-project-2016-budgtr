package io.waldstein.gethip.budgtr;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.waldstein.gethip.budgtr.model.Transaction;

@Path("transactions")
public class TransactionResource {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getTransactionsByAccount(@QueryParam("userId") long userId) {
        return Transaction.find.where().eq("user_id", userId).findList();
    }
	
	@POST
	@Path("create")
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction createTransaction(@QueryParam("userId") long userId) {
		Transaction t = new Transaction(userId);
		t.save();
		return t;
    }
	
	
}
