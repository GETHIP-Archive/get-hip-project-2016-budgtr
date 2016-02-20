package io.waldstein.gethip.budgtr;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.avaje.ebean.Ebean;
import io.waldstein.gethip.budgtr.model.Transaction;

@Path("/{userid}/transaction")
public class TransactionResource {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getTransactionsByAccount(@PathParam("userid") String userid) {
        return Transaction.find.where().eq("userId", userid).findList();
    }
	
	@Path("create")
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction createTransaction(@PathParam("userid") long userid) {
		return new Transaction(userid);
    }
	
	
}
