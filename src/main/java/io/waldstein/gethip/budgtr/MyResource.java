package io.waldstein.gethip.budgtr;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.avaje.ebean.Ebean;
import com.avaje.ebean.TxRunnable;

import io.waldstein.gethip.budgtr.model.Transaction;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getIt() {
		Ebean.execute(new TxRunnable() {
			public void run() {

				Transaction t = new Transaction();
				t.name = "Test Name";

				Ebean.save(t);
			}
		});

		return "Got it!";
	}
}
