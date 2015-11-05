package controllers;

import managers.CarManager;
import models.Car;
import play.Routes;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.cars.list;
import views.html.cars.create;
import views.html.cars.edit_form;

import java.util.List;

/**
 * Created by jesu on 23/10/2015.
 */
public class CarsController extends Controller {

	private final Class<Car> CLASS = Car.class;

	public Result list() {
		List<Car> result = CarManager.instance().getAll();
		return ok( list.render(result, Form.form(CLASS)) );
	}

	public Result create() {
		Form<Car> form = Form.form(CLASS);
		return ok( create.render(form) );
	}

	public Result save() {
		Form<Car> carForm = Form.form(CLASS).bindFromRequest();
		if ( carForm.hasErrors() ) {
			System.out.println("**** " + carForm.errorsAsJson() );
			return badRequest( create.render(carForm) );
		} else {
			carForm.get().save();
			return redirect( routes.CarsController.list() );
		}
	}

	public Result update(Long id) {
		Form<Car> carForm = Form.form(CLASS).bindFromRequest();
		carForm.get().setId(id);
		if ( carForm.hasErrors() ) {
			return badRequest( edit_form.render(carForm, id) );
		} else {
			carForm.get().update();
			return redirect( routes.CarsController.list() );
		}
	}

	public Result edit(Long id) {
		Form<Car> carForm = Form.form(CLASS).fill(CarManager.instance().get(id));
		return ok( edit_form.render(carForm, id) );
	}

	public Result get(Long id) {
		Car car = CarManager.instance().get(id);
		return ok(Json.toJson(car));
	}

	public Result delete(Long id) {
		CarManager.instance().delete(id);
		return redirect( routes.CarsController.list() );
	}

	public Result javascriptRoutes() {
		response().setContentType("text/javascript");
		return ok(
			Routes.javascriptRouter("carsRouter",
					routes.javascript.CarsController.get())
		);
	}

}
