package controllers;

import managers.PersonManager;
import models.Person;
import play.Routes;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.persons.create;
import views.html.persons.edit_form;
import views.html.persons.list;

import java.util.List;

public class Application extends Controller {

	private final Class<Person> CLASS = Person.class;

	public Result list() {
		List<Person> result = PersonManager.instance().getAll();
		return ok( list.render(result) );
	}

	public Result create() {
		Form<Person> form = Form.form(CLASS);
		return ok( create.render(form) );
	}

	public Result save() {
		Form<Person> personForm = Form.form(CLASS).bindFromRequest();
		if ( personForm.hasErrors() ) {
			System.out.println("**** " + personForm.errorsAsJson() );
			return badRequest( create.render(personForm) );
		} else {
			personForm.get().save();
			return redirect(routes.Application.list());
		}
	}

	public Result update(Long id) {
		Form<Person> personForm = Form.form(CLASS).bindFromRequest();
		personForm.get().setId(id);
		if ( personForm.hasErrors() ) {
			System.out.println("**** " + personForm.errorsAsJson() );
			return badRequest( edit_form.render(personForm, id) );
		} else {
			personForm.get().update();
			return redirect( routes.Application.list() );
		}
	}

	public Result edit(Long id) {
		Form<Person> personForm = Form.form(CLASS).fill(PersonManager.instance().get(id));
		return ok( edit_form.render(personForm, id) );
	}

	public Result get(Long id) {
		Person person = PersonManager.instance().get(id);
		return ok(Json.toJson(person));
	}

	public Result delete(Long id) {
		PersonManager.instance().delete(id);
		return redirect( routes.Application.list() );
	}

	public Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(
			Routes.javascriptRouter("personsRouter",
					routes.javascript.Application.get())
				);
	}

}
