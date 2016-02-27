package io.waldstein.gethip.budgtr;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.waldstein.gethip.budgtr.model.Goal;
import com.avaje.ebean.Ebean;

@Path("/goal")
public class GoalResource {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Goal getGoal(@QueryParam("id") long id) {
        return Goal.find.where().eq("id", id).findUnique();
    };
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Goal createGoal(Goal g) {
		Ebean.save(g);
		return g;
    };

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Goal putGoal(@QueryParam("id") long id, Goal g){
    	Goal c = Goal.find.where().eq("id", id).findUnique();
    	c.categoryId = g.categoryId;
        c.amountInCents = g.amountInCents;
    	Ebean.update(c);
    	return c;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Goal deleteGoal(@QueryParam("id") long id){
    	Goal g = Goal.find.where().eq("id",id).findUnique();
    	Ebean.delete(g);
    	return g;
    }
}
