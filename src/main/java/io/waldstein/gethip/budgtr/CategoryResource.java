package io.waldstein.gethip.budgtr;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.waldstein.gethip.budgtr.model.Category;
import com.avaje.ebean.Ebean;

@Path("/category")
public class CategoryResource {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Category getCategory(@QueryParam("id") long id) {
        return Category.find.where().eq("id", id).findUnique();
    };
	
	@POST
    @Produces(MediaType.APPLICATION_JSON)
    public Category createCategory(Category c) {
		Ebean.save(c);
		return c;
    };

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Category putCategory(@QueryParam("id") long id, Category c){
    	Category g = Category.find.where().eq("id", id).findUnique();
    	g.description = c.description;
        g.amountInCents = c.amountInCents;
    	Ebean.update(g);
    	return g;
    }

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Category deleteCategory(@QueryParam("id") long id){
    	Category g = Category.find.where().eq("id", id).findUnique();
    	Ebean.delete(g);
    	return g;
    }
}
