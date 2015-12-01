package controllers;

import models.Listing;
import play.mvc.*;
import play.data.Form;
import views.html.*;
import play.db.ebean.Model;
import java.util.List;
import static play.libs.Json.toJson;

public class Application extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result addListing(){
    	Listing listing = Form.form(Listing.class).bindFromRequest().get();
    	listing.save();
    	return redirect(routes.Application.index());
    }

    public Result getListings(){
    	List<Listing> listings = new Model.Finder(String.class, Listing.class).all();
    	return ok(toJson(listings));
    }
    public Result math(){
        return ok(math.render(" "));
    }

    public Result english(){
        return ok(english.render(" "));
    }
    public Result cs(){
        return ok(cs.render(" "));
    }
}