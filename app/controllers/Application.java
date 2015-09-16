package controllers;

import managers.PersonManager;
import models.Person;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.persons;
import views.html.create;

import java.util.List;

public class Application extends Controller {

	public Result list() {
		List<Person> list = PersonManager.findAll();
		Form<Person> personForm = Form.form(Person.class);
		return ok( persons.render(list, personForm) );
	}

	public Result create() {
		Form<Person> form = Form.form(Person.class);
		return ok( create.render(form) );
	}

	public Result save() {
		Form<Person> personForm = Form.form(Person.class).bindFromRequest();
		if ( personForm.hasErrors() ) {
			System.out.println("**** " + personForm.errorsAsJson() );
			return badRequest( create.render(personForm) );
		} else {
			personForm.get().save();
			return redirect( routes.Application.list() );
		}
	}

}
