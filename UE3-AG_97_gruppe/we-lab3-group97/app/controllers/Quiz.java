package controllers;



import javax.persistence.EntityManager;

import at.ac.tuwien.big.we14.lab2.api.impl.SimpleUser;
import play.*;
import play.data.Form;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import views.html.*;

public class Quiz extends Controller {

    public static Result authentication() {
        return ok(authentication.render());
    }
    
    public static Result registration() {
    	return ok(registration.render());
    }
    
    @Transactional
    public static Result register() {
    	SimpleUser user = Form.form(SimpleUser.class).bindFromRequest().get();
    	JPA.em().persist(user);	
    	return ok(Json.toJson(user));
    	
    }

}