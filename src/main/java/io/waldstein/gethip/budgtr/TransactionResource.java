package io.waldstein.gethip.budgtr;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.TxRunnable;

import io.waldstein.gethip.budgtr.model.Transaction;

@Path("transaction")
public class TransactionResource {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction getTransaction() {
        if (Transaction.find.all().isEmpty()) return new Transaction();
        else return Transaction.find.all().get(0);
    }
	
	@Path("test")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Transaction createTestTransaction() {
		Transaction  t = new Transaction();
		t.name = "test";
		
		Ebean.save(t);
		
		return t;
		
    }
}
