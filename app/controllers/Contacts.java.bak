package controllers;

import play.mvc.*;
import play.data.*;
import com.typesafe.plugin.*;
import static play.data.Form.*;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import views.html.contact.*;

import models.*;

public class Contacts extends Controller {
    
    /**
     * Defines a form wrapping the Contact class.
     */ 
    final static Form<Contact> contactForm = form(Contact.class);
  
    /**
     * Display a blank form.
     */ 
    public static Result blank() {
		return ok(form.render(contactForm));
    }
  
  /*  public static Result edit() {
        Contact existingContact = new Contact("1,2,3,4", "fakecontact@gmail.com");
        return ok(form.render(contactForm.fill(existingContact)));
    }*/
  
    /**
     * Handle the form submission.
     */
    public static Result submit() {
		Form<Contact> filledForm = contactForm.bindFromRequest();
        
        if(filledForm.hasErrors()) {
            return badRequest(form.render(filledForm));
        } else {
            Contact created = filledForm.get();
			
			MailerAPI mail = play.Play.application().plugin(MailerPlugin.class).email();
			mail.setSubject("mailer");
			
			mail.addFrom("test.simarjeet.chera@gmail.com");
			
			mail.addRecipient(created.informations.get(0).email);
			//sends both text and html
			mail.send( "text", "<html>" + sortNumbers(created.informations.get(0).label) + "</html>");
            return ok(summary.render(created));
        }			
		
    }

	private static String sortNumbers(String string) {
		Set<Integer> t = new TreeSet<Integer>();
		StringTokenizer stokenizer =new StringTokenizer(string,",");
		while(stokenizer.hasMoreElements())
			t.add(Integer.parseInt(stokenizer.nextElement().toString()));
			
		return t.toString();
	}
}