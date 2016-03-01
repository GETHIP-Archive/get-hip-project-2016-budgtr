package io.waldstein.gethip.budgtr;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.waldstein.gethip.budgtr.model.Transaction;
import com.avaje.ebean.Ebean;

@Path("/transaction")
public class TransactionResource {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Transaction> getTransaction(@QueryParam("userid") long userid) {
        return Transaction.find.where().eq("user_id", userid).findUnique();
    };
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction createTransaction(Transaction t) {
		Ebean.save(t);
		return t;
    };

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction putTransaction(@QueryParam("id") long id, Transaction t){
    	Transaction c = Transaction.find.where().eq("id", id).findUnique();
    	c.date = t.date;
    	c.userId = t.userId;
    	c.amountInCents = t.amountInCents;
    	c.description = t.description;
    	c.payee = t.payee;
    	c.update();
    	return c;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction deleteTransaction(@QueryParam("id") long id){
    	Transaction t = Transaction.find.where().eq("id",id).findUnique();
    	Ebean.delete(t);
    	return t;
    }
}
