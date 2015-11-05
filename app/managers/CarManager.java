package managers;

import models.Car;


/**
 * Created by jesu on 23/10/2015.
 */
public class CarManager extends DataManager<Car> {

	private static CarManager instance;

	private CarManager() {
		super(Car.class);
	}

	public static CarManager instance() {
		if ( instance == null ) instance = new CarManager();
		return instance;
	}

}
